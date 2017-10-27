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

import com.flight.model.BookingAgents;
import com.flight.repository.BookingAgentsRepo;


@Controller   
@RequestMapping(path="/flightBooking") 
public class BookingAgentsCtrl {
	@Autowired 
	private BookingAgentsRepo repository;

	@GetMapping(path="/addBookingAgent") 
	public @ResponseBody String addNewBA (@RequestParam String name, @RequestParam String details) {

		BookingAgents n = new BookingAgents();
		n.setAgentName(name);
		n.setAgentDetails(details);
		repository.save(n);
		return "Saved";
	}

	@GetMapping(path="/allBookingAgent")
	public @ResponseBody Iterable<BookingAgents> getAll() {
		return repository.findAll();
	}
	

	 @RequestMapping(value = "/getBookingAgentByid/{id}", method = RequestMethod.GET)
	 public @ResponseBody BookingAgents getAirportById(@PathVariable int id) {
		 return repository.findByAgentId(id);
	 }
	
	@DeleteMapping(path="/deleteBookingAgent/{id}")
	public @ResponseBody String deleteByid(@PathVariable int id) {
		repository.delete(id);
		return "deleted";
	}
	
	@RequestMapping(value = "/updateBookingAgent/{id}", method = RequestMethod.PUT)
	public @ResponseBody String updateByid(@PathVariable("id") Integer id, @RequestParam String name, @RequestParam String location, @RequestParam String details){
		BookingAgents a = repository.findByAgentId(id);
		a.setAgentName(name);
		a.setAgentDetails(details);
		repository.save(a);
		return "updated";
		
	}
}



//
