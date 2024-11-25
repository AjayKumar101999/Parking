package com.hcl.empparking.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Allotment {
	
	private Long id;
	private String parkingId;
	private Long empId;
	private String status;
	private LocalDate date;

}
