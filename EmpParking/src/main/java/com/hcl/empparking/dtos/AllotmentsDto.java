package com.hcl.empparking.dtos;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class AllotmentsDto {

	@Min(10000)
	private Long empId;

}