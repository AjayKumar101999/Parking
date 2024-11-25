package com.hcl.empparking.service;

import com.hcl.empparking.dtos.AllotmentsDto;
import com.hcl.empparking.dtos.ApiResponse;

public interface EmployeeService {

	ApiResponse applySpot(AllotmentsDto allotmentsDto);
}
