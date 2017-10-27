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
import com.flight.model.ItineraryReservations;
import com.flight.model.Passengers;
import com.flight.repository.ItineraryReservationRepo;;

@Controller
@RequestMapping(path = "/flightBooking")
public class ItineraryReservationCtrl {
	@Autowired
	private ItineraryReservationRepo repository;

	@GetMapping(path = "/addIR")
	public @ResponseBody String add(@RequestParam int agentId, @RequestParam int passengersId,
			@RequestParam int reservationStatusCode, @RequestParam int ticketTypeCode,
			@RequestParam int travelClassCode, @RequestParam String dateReservationMade,
			@RequestParam int numberInParty) {

		BookingAgents ba = new BookingAgents();
		ba.setAgentId(agentId);

		Passengers pass = new Passengers();
		pass.setPassengersId(passengersId);

		ItineraryReservations n = new ItineraryReservations();

		n.setBookingAgents(ba);
		n.setPassengers(pass);
		n.setReservationStatusCode(reservationStatusCode);
		n.setTicketTypeCode(ticketTypeCode);
		n.setTravelClassCode(travelClassCode);
		n.setDateReservationMade(dateReservationMade);
		n.setNumberInParty(numberInParty);

		repository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/allIR")
	public @ResponseBody Iterable<ItineraryReservations> getAll() {
		return repository.findAll();
	}

	@RequestMapping(value = "/getOneIR/{id}/", method = RequestMethod.GET)
	public @ResponseBody ItineraryReservations getById(@PathVariable int id) {

		return repository.findOne(id);

	}

	@DeleteMapping(path = "/deleteIR/{id}")
	public @ResponseBody String deleteByCode(@PathVariable int id) {

		repository.delete(id);
		return "deleted";
	}

	@RequestMapping(value = "/updateIR/{id}", method = RequestMethod.PUT)
	public @ResponseBody String updateByCode(@PathVariable int id, @RequestParam int agentId,
			@RequestParam int passengersId, @RequestParam int reservationStatusCode, @RequestParam int ticketTypeCode,
			@RequestParam int travelClassCode, @RequestParam String dateReservationMade,
			@RequestParam int numberInParty) {

		BookingAgents ba = new BookingAgents();
		ba.setAgentId(agentId);

		Passengers pass = new Passengers();
		pass.setPassengersId(passengersId);

		ItineraryReservations n = repository.findOne(id);

		n.setBookingAgents(ba);
		n.setPassengers(pass);
		n.setReservationStatusCode(reservationStatusCode);
		n.setTicketTypeCode(ticketTypeCode);
		n.setTravelClassCode(travelClassCode);
		n.setDateReservationMade(dateReservationMade);
		n.setNumberInParty(numberInParty);

		repository.save(n);
		return "updated";
	}
}
