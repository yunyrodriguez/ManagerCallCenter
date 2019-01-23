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
import com.stefanini.hn.util.IncomingCalls;

/**
 * CallLost.
 *
 * @author Yuny Rene Rodriguez Perez <mailto: yrperez@stefanini.com />
 * @version 
 * @see 
 * @since 01-22-2019 03:22:44 PM 2019
 */
@Entity
public class CallLost {

	/** Attribute that determine idCallLost. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCallLost;

	/** Attribute that determine incomingCalls. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = CallCenterConstants.CALL_ID)
	private IncomingCalls incomingCalls;

	/** Attribute that determine timeOut. */
	private Date timeOut;

	/**
	 * Gets the id call lost.
	 *
	 * @return the id call lost
	 */
	public int getIdCallLost() {
		return idCallLost;
	}

	/**
	 * Sets the id call lost.
	 *
	 * @param idCallLost the new id call lost
	 */
	public void setIdCallLost(int idCallLost) {
		this.idCallLost = idCallLost;
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
	 * Gets the time out.
	 *
	 * @return the time out
	 */
	public Date getTimeOut() {
		return timeOut;
	}

	/**
	 * Sets the time out.
	 *
	 * @param timeOut the new time out
	 */
	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

	/**
	 * Instantiates a new call lost.
	 *
	 * @param incomingCalls the incoming calls
	 * @param timeOut the time out
	 */
	public CallLost(IncomingCalls incomingCalls, Date timeOut) {
		this.incomingCalls = incomingCalls;
		this.timeOut = timeOut;
	}

	/**
	 * Instantiates a new call lost.
	 *
	 * @param idCallLost the id call lost
	 */
	public CallLost(int idCallLost) {
		this.idCallLost = idCallLost;
	}

	/**
	 * Instantiates a new call lost.
	 */
	public CallLost() {
	}

}
