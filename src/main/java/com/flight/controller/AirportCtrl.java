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
import com.flight.repository.AirportsRepo;

@Controller    
@RequestMapping(path="/flightBooking") 
public class AirportCtrl {
	@Autowired 
	private AirportsRepo airportRepository;

	@GetMapping(path="/addAirport")
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String location, @RequestParam String details) {

		Airports n = new Airports();
		n.setAirportName(name);
		n.setAirportLocation(location);
		n.setOtherDetails(details);
		
		airportRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/allAirport")
	public @ResponseBody Iterable<Airports> getAllAirport() {
		return airportRepository.findAll();
	}
	
	 @RequestMapping(value = "/getAirportByid/{id}", method = RequestMethod.GET)
	 public @ResponseBody Airports getAirportById(@PathVariable int id) {
		 return airportRepository.findByAirportCode(id);
	 }
	
	@DeleteMapping(path="/deleteAirport/{id}")
	public @ResponseBody String deleteByid(@PathVariable int id) {
		airportRepository.delete(id);
		return "deleted";
	}
	
	@RequestMapping(value = "/updateAirport/{id}", method = RequestMethod.PUT)
	public @ResponseBody String updateByid(@PathVariable("id") Integer id, @RequestParam String name, @RequestParam String location, @RequestParam String details){
		Airports airport = airportRepository.findByAirportCode(id);
		airport.setAirportName(name);
		airport.setAirportLocation(location);
		airport.setOtherDetails(details);
		
		airportRepository.save(airport);
		return "updated";
	}
}




