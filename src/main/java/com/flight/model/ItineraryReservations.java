package com.flight.model;
// Generated Oct 27, 2017 3:14:11 PM by Hibernate Tools 5.2.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ItineraryReservations generated by hbm2java
 */
@Entity
@Table(name = "itinerary_reservations")
public class ItineraryReservations implements java.io.Serializable {

	private Integer revervationId;
	private BookingAgents bookingAgents;
	private Passengers passengers;
	private String dateReservationMade;
	private Integer numberInParty;
	private Integer reservationStatusCode;
	private Integer ticketTypeCode;
	private Integer travelClassCode;
	private Set<Payments> paymentses = new HashSet<Payments>(0);
	private Set<Legs> legses = new HashSet<Legs>(0);

	public ItineraryReservations() {
	}

	public ItineraryReservations(BookingAgents bookingAgents, Passengers passengers, String dateReservationMade,
			Integer numberInParty, Integer reservationStatusCode, Integer ticketTypeCode, Integer travelClassCode,
			Set<Payments> paymentses, Set<Legs> legses) {
		this.bookingAgents = bookingAgents;
		this.passengers = passengers;
		this.dateReservationMade = dateReservationMade;
		this.numberInParty = numberInParty;
		this.reservationStatusCode = reservationStatusCode;
		this.ticketTypeCode = ticketTypeCode;
		this.travelClassCode = travelClassCode;
		this.paymentses = paymentses;
		this.legses = legses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "revervation_id", unique = true, nullable = false)
	public Integer getRevervationId() {
		return this.revervationId;
	}

	public void setRevervationId(Integer revervationId) {
		this.revervationId = revervationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agent_id")
	public BookingAgents getBookingAgents() {
		return this.bookingAgents;
	}

	public void setBookingAgents(BookingAgents bookingAgents) {
		this.bookingAgents = bookingAgents;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "passengers_id")
	public Passengers getPassengers() {
		return this.passengers;
	}

	public void setPassengers(Passengers passengers) {
		this.passengers = passengers;
	}

	@Column(name = "date_reservation_made", length = 50)
	public String getDateReservationMade() {
		return this.dateReservationMade;
	}

	public void setDateReservationMade(String dateReservationMade) {
		this.dateReservationMade = dateReservationMade;
	}

	@Column(name = "number_in_party")
	public Integer getNumberInParty() {
		return this.numberInParty;
	}

	public void setNumberInParty(Integer numberInParty) {
		this.numberInParty = numberInParty;
	}

	@Column(name = "reservation_status_code")
	public Integer getReservationStatusCode() {
		return this.reservationStatusCode;
	}

	public void setReservationStatusCode(Integer reservationStatusCode) {
		this.reservationStatusCode = reservationStatusCode;
	}

	@Column(name = "ticket_type_code")
	public Integer getTicketTypeCode() {
		return this.ticketTypeCode;
	}

	public void setTicketTypeCode(Integer ticketTypeCode) {
		this.ticketTypeCode = ticketTypeCode;
	}

	@Column(name = "travel_class_code")
	public Integer getTravelClassCode() {
		return this.travelClassCode;
	}

	public void setTravelClassCode(Integer travelClassCode) {
		this.travelClassCode = travelClassCode;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "itineraryReservationses")
	public Set<Payments> getPaymentses() {
		return this.paymentses;
	}

	public void setPaymentses(Set<Payments> paymentses) {
		this.paymentses = paymentses;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "itineraryReservationses")
	public Set<Legs> getLegses() {
		return this.legses;
	}

	public void setLegses(Set<Legs> legses) {
		this.legses = legses;
	}

}
