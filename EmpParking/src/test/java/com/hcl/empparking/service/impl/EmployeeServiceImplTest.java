package com.hcl.empparking.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.empparking.dtos.AllotmentsDto;
import com.hcl.empparking.dtos.ApiResponse;
import com.hcl.empparking.entity.Allotment;
import com.hcl.empparking.entity.ParkingSpots;
import com.hcl.empparking.exception.EmployeeNotFoundException;
import com.hcl.empparking.repository.AllotmentsRepo;
import com.hcl.empparking.repository.EmployeeRepo;
import com.hcl.empparking.repository.ParkingSpotsRepo;

@SpringBootTest
class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;

	@Mock
	EmployeeRepo employeeRepo;

	@Mock
	ParkingSpotsRepo parkingSpotsRepo;

	@Mock
	AllotmentsRepo allotmentsRepo;

	ApiResponse apiResponse;
	AllotmentsDto allotmentsDto;
	Allotment allotment;
	ParkingSpots parkingSpots;

	@BeforeEach
	void setup() {
		Long id = (long) 111111;
		allotmentsDto = new AllotmentsDto();
		allotmentsDto.setEmpId(id);
		allotment = new Allotment();
		allotment.setEmpId(id);
		allotment.setStatus("Pending");

		parkingSpots = new ParkingSpots();
		parkingSpots.setParkingStatus("Not_Available");
	}

	@Test
	void test_EmployeeNotFoundException() {

		when(employeeRepo.existsByEmpId(allotmentsDto.getEmpId())).thenReturn(false);
		assertThrows(EmployeeNotFoundException.class, () -> {
			employeeServiceImpl.applySpot(allotmentsDto);
		});
	}

//	@Test
//	void test_EmployeeAlreadyHaveParkingSpotException() {
//		doReturn(Optional.of(parkingSpots)).when(parkingSpotsRepo.findByEmpId(allotmentsDto.getEmpId()));
//		assertThrows(EmployeeAlreadyHaveParkingSpotException.class, () -> {
//			employeeServiceImpl.applySpot(allotmentsDto);
//		});
//	}

//	@Test
//	void test_EmployeeAlreadyRequestedException() {
//		doReturn(Optional.of(allotment)).when(allotmentsRepo.findByEmpId(allotmentsDto.getEmpId()));
//		assertThrows(EmployeeAlreadyRequestedException.class, () -> {
//			employeeServiceImpl.applySpot(allotmentsDto);
//		});
//	}

//	@Test
//	void test_allotmentSave() {
//		apiResponse = new ApiResponse("SC1006", "Employee Swipe data Inserted successfully");
//		when(employeeRepo.existsByEmpId(allotmentsDto.getEmpId())).thenReturn(true);
//		parkingSpots.setParkingStatus("Available");
//		doReturn(Optional.of(parkingSpots)).when(parkingSpotsRepo.findByEmpId(allotmentsDto.getEmpId()));
//		doReturn(Optional.empty()).when(allotmentsRepo.findByEmpId(allotmentsDto.getEmpId()));
//
//		assertThat(employeeServiceImpl.applySpot(allotmentsDto)).isEqualTo(apiResponse);
//	}
}
