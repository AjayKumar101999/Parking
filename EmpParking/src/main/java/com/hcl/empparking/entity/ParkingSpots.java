package com.hcl.empparking.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ParkingSpots {
	@Id
	private String parkingId;
	private Long empId;
	private String parkingStatus;
	private LocalDate fromDate;
	private LocalDate toDate;

}
