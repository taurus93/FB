package com.flight.repository;

import org.springframework.data.repository.CrudRepository;

import com.flight.model.Legs;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LegRepo extends CrudRepository<Legs, Integer> {


}


