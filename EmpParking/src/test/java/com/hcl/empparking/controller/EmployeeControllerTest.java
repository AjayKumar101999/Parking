package com.hcl.empparking.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.empparking.dtos.AllotmentsDto;
import com.hcl.empparking.dtos.ApiResponse;
import com.hcl.empparking.service.EmployeeService;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest
class EmployeeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Mock
	private EmployeeService empService;

	@InjectMocks
	EmployeeController employeeController;

	ApiResponse apiResponse;
	AllotmentsDto allotmentsDto;

	@BeforeEach
	void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	@Test
	void test_saveSwipes() throws Exception {
		apiResponse = new ApiResponse("SC1001", "Employee data Inserted successfully");
		allotmentsDto = new AllotmentsDto();
		Long id = (long) 111111;
		allotmentsDto.setEmpId(id);
		String writeValueAsString = new ObjectMapper().writeValueAsString(allotmentsDto);

		when(empService.applySpot(allotmentsDto)).thenReturn(apiResponse);
		this.mockMvc.perform(
				post("/api/v1/emp-parkings").content(writeValueAsString).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andDo(print());
	}
}
