package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.model.Airports;
import com.flight.model.FlightSchedules;
import com.flight.model.Legs;
import com.flight.repository.LegRepo;


@Controller   
@RequestMapping(path="/flightBooking") 
public class LegController {
	@Autowired 
	private LegRepo repository;

	@GetMapping(path="/addLeg") 
	public @ResponseBody String addNewUser (@RequestParam Airports airports
			, @RequestParam FlightSchedules flightSchedules, @RequestParam String actualDepartureTime, @RequestParam int destinationAirportCode) {

		Legs n = new Legs();
		n.setAirports(airports);
		n.setFlightSchedules(flightSchedules);
		n.setActualDepartureTime(actualDepartureTime);
		n.setDestinationAirportCode(destinationAirportCode);
		
		repository.save(n);
		return "Saved";
	}

	@GetMapping(path="/allLeg")
	public @ResponseBody Iterable<Legs> getAll() {
		return repository.findAll();
	}

	 @RequestMapping(value = "/leg/{code}", method = RequestMethod.GET)
	 public @ResponseBody Legs getAirportById(@PathVariable int code) {
		 return repository.findOne(code);
	 }
	
	@DeleteMapping(path="/leg/{code}")
	public @ResponseBody String deleteByCode(@PathVariable int code) {
		repository.delete(code);
		return "deleted";
	}
	
	@RequestMapping(value = "/leg/{code}", method = RequestMethod.PUT)
	public @ResponseBody String updateByCode(@PathVariable("code") Integer code, @RequestParam Airports airports
			, @RequestParam FlightSchedules flightSchedules, @RequestParam String actualDepartureTime, @RequestParam int destinationAirportCode){
		Legs n = repository.findOne(code);
		n.setAirports(airports);
		n.setFlightSchedules(flightSchedules);
		n.setActualDepartureTime(actualDepartureTime);
		n.setDestinationAirportCode(destinationAirportCode);
		repository.save(n);
		return "updated";
	}
}




