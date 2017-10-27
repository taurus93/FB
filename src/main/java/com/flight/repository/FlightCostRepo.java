package com.flight.repository;

import org.springframework.data.repository.CrudRepository;

import com.flight.model.FlightCosts;
import com.flight.model.FlightCostsId;;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FlightCostRepo extends CrudRepository<FlightCosts, FlightCostsId> {

	FlightCosts findById(FlightCostsId id);

}


