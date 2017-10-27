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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BookingAgents generated by hbm2java
 */
@Entity
@Table(name = "booking_agents")
public class BookingAgents implements java.io.Serializable {

	private Integer agentId;
	private String agentDetails;
	private String agentName;
	private Set<ItineraryReservations> itineraryReservationses = new HashSet<ItineraryReservations>(0);

	public BookingAgents() {
	}

	public BookingAgents(String agentDetails, String agentName, Set<ItineraryReservations> itineraryReservationses) {
		this.agentDetails = agentDetails;
		this.agentName = agentName;
		this.itineraryReservationses = itineraryReservationses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "agent_id", unique = true, nullable = false)
	public Integer getAgentId() {
		return this.agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	@Column(name = "agent_details")
	public String getAgentDetails() {
		return this.agentDetails;
	}

	public void setAgentDetails(String agentDetails) {
		this.agentDetails = agentDetails;
	}

	@Column(name = "agent_name", length = 20)
	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingAgents")
	public Set<ItineraryReservations> getItineraryReservationses() {
		return this.itineraryReservationses;
	}

	public void setItineraryReservationses(Set<ItineraryReservations> itineraryReservationses) {
		this.itineraryReservationses = itineraryReservationses;
	}

}
