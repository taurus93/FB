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

import com.flight.model.Payments;
import com.flight.repository.PaymentsRepo;


@Controller  
@RequestMapping(path="/flightBooking") 
public class PaymentsCtrl {
	@Autowired 
	private PaymentsRepo repository;

	@GetMapping(path="/addPayment") 
	public @ResponseBody String addNewUser (@RequestParam int paymentAmount
			, @RequestParam String paymentDate, @RequestParam String paymentStatusCode) {

		Payments n = new Payments();
		n.setPaymentAmount(paymentAmount);
		n.setPaymentDate(paymentDate);
		n.setPaymentStatusCode(paymentStatusCode);
		
		repository.save(n);
		return "Saved";
	}

	@GetMapping(path="/allPayment")
	public @ResponseBody Iterable<Payments> getAll() {
		return repository.findAll();
	}
	
	 @RequestMapping(value = "/getPaymentByCode/{code}", method = RequestMethod.GET)
	 public @ResponseBody Payments getAirportById(@PathVariable int code) {
		 return repository.findOne(code);
	 }
	
	@DeleteMapping(path="/deletePayment/{code}")
	public @ResponseBody String deleteByCode(@PathVariable int code) {
		repository.delete(code);
		return "deleted";
	}
	
	@RequestMapping(value = "/updatePayment/{code}", method = RequestMethod.PUT)
	public @ResponseBody String updateByCode(@PathVariable("code") Integer code, @RequestParam int paymentAmount,  @RequestParam String paymentDate, @RequestParam String paymentStatusCode){
		Payments n = repository.findOne(code);
		n.setPaymentAmount(paymentAmount);
		n.setPaymentDate(paymentDate);
		n.setPaymentStatusCode(paymentStatusCode);
		repository.save(n);
		return "updated";
	}
}




