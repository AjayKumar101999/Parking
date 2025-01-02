package com.hcl.empparking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.empparking.entity.ParkingSpots;

@Repository
public interface ParkingSpotsRepo extends JpaRepository<ParkingSpots, String> {
	public Optional<ParkingSpots> findByParkingId(String parkingId);

	public boolean existsByParkingId(String parkingId);

}
