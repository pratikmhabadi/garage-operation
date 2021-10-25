package com.garage.garage.dao;

import com.garage.garage.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

}
