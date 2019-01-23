package com.stefanini.hn.controller;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.stefanini.hn.constants.CallCenterConstants;
import com.stefanini.hn.util.Employee;
import com.stefanini.hn.util.IncomingCalls;

/**
 * CallsAnswered.
 *
 * @author Yuny Rene Rodriguez Perez <mailto: yrperez@stefanini.com />
 * @version 
 * @see 
 * @since 01-22-2019 03:22:38 PM 2019
 */
@Entity
public class CallsAnswered {

	/** Attribute that determine idCallsAnswered. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCallsAnswered;

	/** Attribute that determine incomingCalls. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = CallCenterConstants.CALL_ID)
	private IncomingCalls incomingCalls;

	/** Attribute that determine timeAttended. */
	private Date timeAttended;

	/** Attribute that determine employee. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = CallCenterConstants.EMPLOYEE_ID)
	private Employee employee;

	/**
	 * Gets the id calls answered.
	 *
	 * @return the id calls answered
	 */
	public int getIdCallsAnswered() {
		return idCallsAnswered;
	}

	/**
	 * Sets the id calls answered.
	 *
	 * @param idCallsAnswered the new id calls answered
	 */
	public void setIdCallsAnswered(int idCallsAnswered) {
		this.idCallsAnswered = idCallsAnswered;
	}

	/**
	 * Gets the incoming calls.
	 *
	 * @return the incoming calls
	 */
	public IncomingCalls getIncomingCalls() {
		return incomingCalls;
	}

	/**
	 * Sets the incoming calls.
	 *
	 * @param incomingCalls the new incoming calls
	 */
	public void setIncomingCalls(IncomingCalls incomingCalls) {
		this.incomingCalls = incomingCalls;
	}

	/**
	 * Gets the time attended.
	 *
	 * @return the time attended
	 */
	public Date getTimeAttended() {
		return timeAttended;
	}

	/**
	 * Sets the time attended.
	 *
	 * @param timeAttended the new time attended
	 */
	public void setTimeAttended(Date timeAttended) {
		this.timeAttended = timeAttended;
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * Instantiates a new calls answered.
	 *
	 * @param incomingCalls the incoming calls
	 * @param timeAttended the time attended
	 * @param employee the employee
	 */
	public CallsAnswered(IncomingCalls incomingCalls, Date timeAttended, Employee employee) {
		this.incomingCalls = incomingCalls;
		this.timeAttended = timeAttended;
		this.employee = employee;
	}

	/**
	 * Instantiates a new calls answered.
	 *
	 * @param idCallsAnswered the id calls answered
	 */
	public CallsAnswered(int idCallsAnswered) {	
		this.idCallsAnswered = idCallsAnswered;
	}

	/**
	 * Instantiates a new calls answered.
	 */
	public CallsAnswered() {
		
	}

}
