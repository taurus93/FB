package com.flight.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.model.FlightCosts;
import com.flight.model.FlightCostsId;
import com.flight.model.FlightSchedules;
import com.flight.model.RefCalendar;
import com.flight.repository.FlightCostRepo;;
	

@Controller    
@RequestMapping(path="/flightBooking") 
public class FlightCostCtrl {
	@Autowired 
	private FlightCostRepo repository;

	@GetMapping(path="/addFlightCost") 
	public @ResponseBody String addNewUser (@RequestParam int aircraftTypeCode, @RequestParam int flightNumber, @RequestParam String dayDate, @RequestParam String flightCost, @RequestParam String validToDate) {
		

		FlightCosts n = new FlightCosts();
		n.setFlightCost(flightCost);
		n.setValidToDate(validToDate);
		
		FlightCostsId fci = new FlightCostsId();
		fci.setAircraftTypeCode(aircraftTypeCode);
		fci.setDayDate(dayDate);
		fci.setFlightNumber(flightNumber);
		
		FlightSchedules fs = new FlightSchedules();
		fs.setFlightNumber(flightNumber);
		RefCalendar rc = new RefCalendar();
		rc.setDayDate(dayDate);
		
		n.setFlightSchedules(fs);
		n.setRefCalendar(rc);
		n.setId(fci);
		
		repository.save(n);
		return "Saved";
	}

	@GetMapping(path="/allFlightCost")
	public @ResponseBody Iterable<FlightCosts> getAll() {
		return repository.findAll();
	}
	

	 @RequestMapping(value = "/getOneFlightCost/{code}/{flightNumber}/{dayDate}", method = RequestMethod.GET)
	 public @ResponseBody ResponseEntity<?> getAirportById(@PathVariable int code, @PathVariable Integer flightNumber, @PathVariable String dayDate) {
		 
		 FlightCostsId fci = new FlightCostsId();
		 fci.setAircraftTypeCode(code);
		 fci.setDayDate(dayDate);
		 fci.setFlightNumber(flightNumber);
		 
		 FlightCosts fc = repository.findById(fci);
		 
		 Logger logger = LoggerFactory.getLogger(FlightCostCtrl.class);
		 
		 if (fc == null) {
			logger.error("StudentAdd with id {} not found.", fc);
			return new ResponseEntity<Object>(new ErrorType("studentAdd with id " + fc + " not found"),
					HttpStatus.NOT_FOUND);
		}
	        
	        return new ResponseEntity<FlightCosts>(fc, HttpStatus.OK);
		 
		 
	 }
	
	@DeleteMapping(path="/deleteFlightCost/{code}/{flightNumber}/{dayDate}")
	public @ResponseBody String deleteByCode(@PathVariable int code, @PathVariable Integer flightNumber, @PathVariable String dayDate) {
		
		FlightCostsId fci = new FlightCostsId();
		fci.setAircraftTypeCode(code);
		fci.setDayDate(dayDate);
		fci.setFlightNumber(flightNumber);
		
		repository.delete(fci);
		return "deleted";
	}
	
	@RequestMapping(value = "/updateFlightCost/{code}/{flightNumber}/{dayDate}", method = RequestMethod.PUT)
	public @ResponseBody String updateByCode(@PathVariable int code, @PathVariable int flightNumber, @PathVariable String dayDate, @RequestParam int flightNumber1, @RequestParam String dayDate1, @RequestParam String flightCost, @RequestParam String validToDate){
	
		FlightCostsId fci = new FlightCostsId();
		fci.setAircraftTypeCode(code);
		fci.setDayDate(dayDate);
		fci.setFlightNumber(flightNumber);
		
		FlightCosts n = repository.findById(fci);
		
		n.setFlightCost(flightCost);
		n.setValidToDate(validToDate);
		
		repository.save(n);
		return "updated";
	}
}




