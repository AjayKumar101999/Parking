package com.hcl.empparking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.empparking.entity.Allotment;

@Repository
public interface AllotmentsRepo extends JpaRepository<Allotment, Long> {
	public Optional<Allotment> findByEmpId(Long empId);
}
