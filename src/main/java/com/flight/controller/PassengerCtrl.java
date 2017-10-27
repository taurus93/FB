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

import com.flight.model.Passengers;
import com.flight.repository.PassengerRepo;


@Controller    
@RequestMapping(path="/flightBooking") 
public class PassengerCtrl {
	@Autowired 
	private PassengerRepo repository;

	@GetMapping(path="/addPass") 
	public @ResponseBody String addNewUser (@RequestParam String agentDetails, @RequestParam String addressLines, @RequestParam String city, @RequestParam String country, @RequestParam String firstName,@RequestParam String secondName
			, @RequestParam String lastName, @RequestParam String phoneNumber, @RequestParam String otherPassengerDetails, @RequestParam String stateProvinceCounty) {
		

		Passengers n = new Passengers();
		n.setFirstName(firstName);
		n.setSecondName(secondName);
		n.setLastName(lastName);
		n.setPhoneNumber(phoneNumber);
		n.setOtherPassengerDetails(otherPassengerDetails);
		n.setStateProvinceCounty(stateProvinceCounty);
		n.setCity(city);
		n.setCountry(country);
		n.setAddressLines(addressLines);
		
		repository.save(n);
		return "Saved";
	}

	@GetMapping(path="/allPass")
	public @ResponseBody Iterable<Passengers> getAll() {
		return repository.findAll();
	}
	

	 @RequestMapping(value = "/pass/{code}", method = RequestMethod.GET)
	 public @ResponseBody Passengers getAirportById(@PathVariable int code) {
		 return repository.findOne(code);
	 }
	
	@DeleteMapping(path="/pass/{code}")
	public @ResponseBody String deleteByCode(@PathVariable int code) {
		repository.delete(code);
		return "delete";
	}
	
	@RequestMapping(value = "/pass/{code}", method = RequestMethod.PUT)
	public @ResponseBody String updateByCode(@PathVariable("code") Integer code, @RequestParam String agentDetails, @RequestParam String addressLines, @RequestParam String city, @RequestParam String country, @RequestParam String firstName,@RequestParam String secondName
			, @RequestParam String lastName, @RequestParam String phoneNumber, @RequestParam String otherPassengerDetails, @RequestParam String stateProvinceCounty){
		Passengers n = repository.findOne(code);
		n.setFirstName(firstName);
		n.setSecondName(secondName);
		n.setLastName(lastName);
		n.setPhoneNumber(phoneNumber);
		n.setOtherPassengerDetails(otherPassengerDetails);
		n.setStateProvinceCounty(stateProvinceCounty);
		n.setCity(city);
		n.setCountry(country);
		n.setAddressLines(addressLines);
		repository.save(n);
		return "updated";
	}
}




