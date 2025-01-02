package com.hcl.empparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee Parking Slot Booking Application API's Documentation")

)
public class EmpParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpParkingApplication.class, args);
	}
	

}
