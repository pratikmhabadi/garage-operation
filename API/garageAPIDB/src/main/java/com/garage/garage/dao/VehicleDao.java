package com.garage.garage.dao;

import com.garage.garage.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findAllByStatus(String vehicleStatus);

    List<Vehicle> findAllByType(String vehicleType);
}
