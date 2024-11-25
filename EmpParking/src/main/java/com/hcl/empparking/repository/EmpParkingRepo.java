package com.hcl.empparking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.empparking.entity.EmpParking;
import com.hcl.empparking.entity.Employee;

@Repository
public interface EmpParkingRepo extends JpaRepository<EmpParking, Long> {
	public Optional<EmpParking> findByEmpId(Employee empId);

}
