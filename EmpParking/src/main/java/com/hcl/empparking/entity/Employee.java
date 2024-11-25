package com.hcl.empparking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	private Long empId;
	private String empName;
	private String email;
	private String password;

}
