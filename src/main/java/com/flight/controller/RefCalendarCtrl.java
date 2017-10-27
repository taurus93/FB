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

import com.flight.model.RefCalendar;
import com.flight.repository.RefCalendarRepo;


@Controller   
@RequestMapping(path="/flightBooking") 
public class RefCalendarCtrl {
	@Autowired 
	private RefCalendarRepo repository;

	@GetMapping(path="/addRC") 
	public @ResponseBody String addNewUser (@RequestParam String businessDayYn
			, @RequestParam String dayDate, @RequestParam int dayNumber) {
		RefCalendar n = new RefCalendar();
		n.setBusinessDayYn(businessDayYn);
		n.setDayDate(dayDate);
		n.setDayNumber(dayNumber);
		
		repository.save(n);
		return "Saved";
	}

	@GetMapping(path="/allRC")
	public @ResponseBody Iterable<RefCalendar> getAll() {
		return repository.findAll();
	}

	 @RequestMapping(value = "/getRCByCode/{code}", method = RequestMethod.GET)
	 public @ResponseBody RefCalendar getById(@PathVariable int code) {
		 return repository.findOne(code);
	 }
	
	@DeleteMapping(path="/deleteRC/{code}")
	public @ResponseBody String deleteById(@PathVariable int code) {
		repository.delete(code);
		return "deleted";
	}
	
	@RequestMapping(value = "/updateRC/{code}", method = RequestMethod.PUT)
	public @ResponseBody String updateById(@PathVariable("code") Integer code, @RequestParam String businessDayYn,  @RequestParam String paymentDate, @RequestParam String dayDate, @RequestParam int dayNumber){
		RefCalendar n = repository.findOne(code);
		n.setBusinessDayYn(businessDayYn);
		n.setDayDate(dayDate);
		n.setDayNumber(dayNumber);
		repository.save(n);
		return "updated";
	}
}




