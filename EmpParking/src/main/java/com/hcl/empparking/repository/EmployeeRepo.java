package com.hcl.empparking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.empparking.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	public Optional<Employee> findByEmpId(Long empId);
	public Optional<Employee> findByEmpName(String empName);
	public boolean existsByEmpId(Long empId);
}
