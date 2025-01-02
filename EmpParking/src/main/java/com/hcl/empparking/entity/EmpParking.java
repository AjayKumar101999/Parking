package com.hcl.empparking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class EmpParking {
	@Id
	private Long id;

	@OneToOne
	@JoinColumn(name = "empId", referencedColumnName = "empId")
	private Employee empId;

	@OneToOne
	@JoinColumn(name = "parkingId", referencedColumnName = "parkingId")
	private ParkingSpots parkingId;

}
