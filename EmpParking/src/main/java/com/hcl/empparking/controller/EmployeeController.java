package com.hcl.empparking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.empparking.dtos.AllotmentsDto;
import com.hcl.empparking.dtos.ApiResponse;
import com.hcl.empparking.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "REST APIs for requesting parking Slot")
@RestController
@RequestMapping(path = "/api/v1")
@Validated
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService empService;

	/**
	 * This method will create parking request details in database
	 * 
	 * @param AllotmentsDto which contain the information of empId data.
	 * @return
	 */
	@Operation(summary = " API to insert parking request details in database")
	@PostMapping("/emp-parkings")
	public ResponseEntity<ApiResponse> requestParkingSpot(@Valid @RequestBody AllotmentsDto allotmentsDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(empService.applySpot(allotmentsDto));
	}
}
