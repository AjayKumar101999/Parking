package com.hcl.empparking.service.impl;

import java.util.Optional;

//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hcl.empparking.dtos.AllotmentsDto;
import com.hcl.empparking.dtos.ApiResponse;
import com.hcl.empparking.entity.Allotment;
import com.hcl.empparking.entity.EmpParking;
import com.hcl.empparking.entity.Employee;
import com.hcl.empparking.enums.AllotmentStatus;
import com.hcl.empparking.exception.EmployeeAlreadyHaveParkingSpotException;
import com.hcl.empparking.exception.EmployeeAlreadyRequestedException;
import com.hcl.empparking.exception.EmployeeNotFoundException;
import com.hcl.empparking.kafka.sendor.KafkaSendor;
import com.hcl.empparking.mapper.CustomMapper;
import com.hcl.empparking.repository.AllotmentsRepo;
import com.hcl.empparking.repository.EmpParkingRepo;
import com.hcl.empparking.repository.EmployeeRepo;
import com.hcl.empparking.service.EmployeeService;
import com.hcl.empparking.utils.Responses;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(value = "empService")
@RequiredArgsConstructor
//public class EmployeeServiceImpl implements UserDetailsService, EmployeeService {
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepo employeeRepo;
	private final EmpParkingRepo empParkingRepo;
	private final AllotmentsRepo allotmentsRepo;
	private final KafkaSendor kafkaSendor;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<Employee> emp = employeeRepo.findByEmpName(username);	
//		if (emp.isEmpty()) {
//			throw new UsernameNotFoundException("Invalid username or password");
//		}
//		return new User(emp.get().getEmpName(), emp.get().getPassword(), getAuthority());
//	}
//	
//	public List<SimpleGrantedAuthority> getAuthority() {
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//	}

	@Override
	public ApiResponse applySpot(AllotmentsDto allotmentsDto) {
		Employee emp = employeeRepo.findByEmpId(allotmentsDto.getEmpId()).orElseThrow(() -> {
			throw new EmployeeNotFoundException(Responses.EMP_NOT_FOUND_MESSAGE);
		});

		Optional<EmpParking> empParking = empParkingRepo.findByEmpId(emp);
		if (empParking.isPresent()) {
			throw new EmployeeAlreadyHaveParkingSpotException(Responses.EMP_ALREADY_HAVE_PARKING_MSG);
		}

		Optional<Allotment> byEmpId = allotmentsRepo.findByEmpId(allotmentsDto.getEmpId());
		if (byEmpId.isPresent() && byEmpId.get().getEmpId().equals(allotmentsDto.getEmpId())
				&& byEmpId.get().getStatus().equals(AllotmentStatus.Pending.name())) {
			throw new EmployeeAlreadyRequestedException(Responses.EMP_ALREADY_REQUESTED_MSG);

		}
		Allotment newRequest = CustomMapper.dtoToAllotments(allotmentsDto, new Allotment());
		try {
			allotmentsRepo.save(newRequest);
			log.info("Emploee parking request data saved in database");
			kafkaSendor.send(newRequest);
			log.info("Emploee parking request data sent to kafka topic");
		} catch (Exception e) {
			log.info("Emploee parking request data not saved in database");
			log.info(e.getMessage());
			return new ApiResponse(Responses.EMP_DATA_NOT_INSERTED, Responses.EMP_DATA_NOT_INSERTED_MSG);
		}

		return new ApiResponse(Responses.EMP_PARKING_REQUEST_INSERTED, Responses.EMP_PARKING_REQUEST_INSERTED_MSG);
	}

}
