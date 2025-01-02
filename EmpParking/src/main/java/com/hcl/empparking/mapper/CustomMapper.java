package com.hcl.empparking.mapper;

import java.time.LocalDate;

import com.hcl.empparking.dtos.AllotmentsDto;
import com.hcl.empparking.entity.Allotment;
import com.hcl.empparking.enums.AllotmentStatus;

public class CustomMapper {

	public static Allotment dtoToAllotments(AllotmentsDto dto, Allotment allotment) {
		
		allotment.setEmpId(dto.getEmpId());
		allotment.setStatus(AllotmentStatus.Pending.name());
		allotment.setDate(LocalDate.now());

		return allotment;
	}
}
