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
import com.flight.repository.FlightScheduleRepo;


@Controller    
@RequestMapping(path="/flightBooking") 
public class FlightSchedulesCtrl {
	@Autowired 
	private FlightScheduleRepo repository;

	@GetMapping(path="/addFS") 
	public @ResponseBody String addNewUser (@RequestParam int airportCode,@RequestParam int airlineCode
			, @RequestParam String arrivalDateTime, @RequestParam String departureDateTime, @RequestParam int destinationAirportCode, @RequestParam int usualAircraftTypeCode) {
		

		FlightSchedules n = new FlightSchedules();
		n.setAirlineCode(airlineCode);
		n.setUsualAircraftTypeCode(usualAircraftTypeCode);
		n.setDestinationAirportCode(destinationAirportCode);
		n.setArrivalDateTime(arrivalDateTime);
		n.setDepartureDateTime(departureDateTime);
		
		// create a object
		Airports air = new Airports();
		air.setAirportCode(airportCode);
		n.setAirports(air);
		
		repository.save(n);
		return "Saved";
	}

	@GetMapping(path="/allFS")
	public @ResponseBody Iterable<FlightSchedules> getAll() {
		return repository.findAll();
	}
	

	 @RequestMapping(value = "/getFSByCode/{code}", method = RequestMethod.GET)
	 public @ResponseBody FlightSchedules getAirportById(@PathVariable int code) {
		 return repository.findOne(code);
	 }
	
	@DeleteMapping(path="/deleteFS/{code}")
	public @ResponseBody String deleteByCode(@PathVariable int code) {
		repository.delete(code);
		return "delete";
	}
	
	@RequestMapping(value = "/updateFS/{code}", method = RequestMethod.PUT)
	public @ResponseBody String updateByCode(@PathVariable("code") Integer code, @RequestParam int airlineCode,  @RequestParam String arrivalDateTime, @RequestParam String departureDateTime, @RequestParam int destinationAirportCode, @RequestParam int originAirportCode, @RequestParam int usualAircraftTypeCode, @RequestParam Airports airports){
		FlightSchedules n = repository.findOne(code);
		n.setAirlineCode(airlineCode);
		n.setUsualAircraftTypeCode(usualAircraftTypeCode);
		n.setDestinationAirportCode(destinationAirportCode);
		n.setArrivalDateTime(arrivalDateTime);
		n.setDepartureDateTime(departureDateTime);
		n.setAirports(airports);
		repository.save(n);
		return "updated";
	}
}




