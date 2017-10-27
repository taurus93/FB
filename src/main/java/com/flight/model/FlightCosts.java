package com.flight.model;
// Generated Oct 27, 2017 3:14:11 PM by Hibernate Tools 5.2.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FlightCosts generated by hbm2java
 */
@Entity
@Table(name = "flight_costs")
public class FlightCosts implements java.io.Serializable {

	private FlightCostsId id;
	private FlightSchedules flightSchedules;
	private RefCalendar refCalendar;
	private String flightCost;
	private String validToDate;

	public FlightCosts() {
	}

	public FlightCosts(FlightCostsId id, FlightSchedules flightSchedules, RefCalendar refCalendar) {
		this.id = id;
		this.flightSchedules = flightSchedules;
		this.refCalendar = refCalendar;
	}

	public FlightCosts(FlightCostsId id, FlightSchedules flightSchedules, RefCalendar refCalendar, String flightCost,
			String validToDate) {
		this.id = id;
		this.flightSchedules = flightSchedules;
		this.refCalendar = refCalendar;
		this.flightCost = flightCost;
		this.validToDate = validToDate;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "aircraftTypeCode", column = @Column(name = "aircraft_type_code", nullable = false)),
			@AttributeOverride(name = "flightNumber", column = @Column(name = "flight_number", nullable = false)),
			@AttributeOverride(name = "dayDate", column = @Column(name = "day_date", nullable = false, length = 50)) })
	public FlightCostsId getId() {
		return this.id;
	}

	public void setId(FlightCostsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_number", nullable = false, insertable = false, updatable = false)
	public FlightSchedules getFlightSchedules() {
		return this.flightSchedules;
	}

	public void setFlightSchedules(FlightSchedules flightSchedules) {
		this.flightSchedules = flightSchedules;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "day_date", nullable = false, insertable = false, updatable = false)
	public RefCalendar getRefCalendar() {
		return this.refCalendar;
	}

	public void setRefCalendar(RefCalendar refCalendar) {
		this.refCalendar = refCalendar;
	}

	@Column(name = "flight_cost")
	public String getFlightCost() {
		return this.flightCost;
	}

	public void setFlightCost(String flightCost) {
		this.flightCost = flightCost;
	}

	@Column(name = "valid_to_date", length = 50)
	public String getValidToDate() {
		return this.validToDate;
	}

	public void setValidToDate(String validToDate) {
		this.validToDate = validToDate;
	}

}