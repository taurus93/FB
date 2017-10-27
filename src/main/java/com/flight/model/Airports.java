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
 * Airports generated by hbm2java
 */
@Entity
@Table(name = "airports")
public class Airports implements java.io.Serializable {

	private Integer airportCode;
	private String airportLocation;
	private String airportName;
	private String otherDetails;
	private Set<FlightSchedules> flightScheduleses = new HashSet<FlightSchedules>(0);
	private Set<Legs> legses = new HashSet<Legs>(0);

	public Airports() {
	}

	public Airports(String airportLocation, String airportName, String otherDetails,
			Set<FlightSchedules> flightScheduleses, Set<Legs> legses) {
		this.airportLocation = airportLocation;
		this.airportName = airportName;
		this.otherDetails = otherDetails;
		this.flightScheduleses = flightScheduleses;
		this.legses = legses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "airport_code", unique = true, nullable = false)
	public Integer getAirportCode() {
		return this.airportCode;
	}

	public void setAirportCode(Integer airportCode) {
		this.airportCode = airportCode;
	}

	@Column(name = "airport_location", length = 50)
	public String getAirportLocation() {
		return this.airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	@Column(name = "airport_name", length = 20)
	public String getAirportName() {
		return this.airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	@Column(name = "other_details")
	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "airports")
	public Set<FlightSchedules> getFlightScheduleses() {
		return this.flightScheduleses;
	}

	public void setFlightScheduleses(Set<FlightSchedules> flightScheduleses) {
		this.flightScheduleses = flightScheduleses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "airports")
	public Set<Legs> getLegses() {
		return this.legses;
	}

	public void setLegses(Set<Legs> legses) {
		this.legses = legses;
	}

}
