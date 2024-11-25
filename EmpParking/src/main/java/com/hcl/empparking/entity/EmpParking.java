package com.hcl.empparking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class EmpParking {
	@Id
	private Long id;

	@OneToOne
	private Employee empId;

	@OneToOne
	private ParkingSpots parkingId;

}
