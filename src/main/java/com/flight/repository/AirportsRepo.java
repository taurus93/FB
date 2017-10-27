package com.flight.repository;

import org.springframework.data.repository.CrudRepository;

import com.flight.model.Airports;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AirportsRepo extends CrudRepository<Airports, Integer> {

	Airports findByAirportCode(int id);


}


