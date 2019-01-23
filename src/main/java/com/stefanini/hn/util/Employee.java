package com.stefanini.hn.util;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.stefanini.hn.constants.CallCenterConstants;
import com.stefanini.hn.controller.CallsAnswered;

/**
 * Employee.
 *
 * @author Yuny Rene Rodriguez Perez <mailto: yrperez@stefanini.com />
 * @version 
 * @see 
 * @since 01-22-2019 03:23:05 PM 2019
 */
@Entity
public class Employee {

	/** Attribute that determine idEmployee. */
	@Id
	private Long idEmployee;
	
	/** Attribute that determine firstName. */
	private String firstName;
	
	/** Attribute that determine secondName. */
	private String secondName;
	
	/** Attribute that determine phonenumber. */
	private String phonenumber;
	
	/** Attribute that determine typeEmployee. */
	private String typeEmployee;
	
	/** Attribute that determine disponibilty. */
	private boolean disponibilty;

	/** Attribute that determine callAnswered. */
	@OneToMany(mappedBy = CallCenterConstants.CONSTANT_EMPLOYEE)
	private List<CallsAnswered> callAnswered;

	/**
	 * Instantiates a new employee.
	 */
	public Employee() {
		super();
	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param id the id
	 */
	public Employee(Long id) {
		super();
		this.idEmployee = id;
	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param id the id
	 * @param firstName the first name
	 * @param secondName the second name
	 * @param phonenumber the phonenumber
	 * @param typeEmployee the type employee
	 * @param disponibilty the disponibilty
	 */
	public Employee(Long id, String firstName, String secondName, String phonenumber, String typeEmployee,
			boolean disponibilty) {

		this.idEmployee = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.phonenumber = phonenumber;
		this.typeEmployee = typeEmployee;
		this.disponibilty = disponibilty;
	}

	/**
	 * Adds the calls answered.
	 *
	 * @param c the c
	 */
	public void addCallsAnswered(CallsAnswered c) {

		callAnswered.add(c);
	}

	/**
	 * Gets the id employee.
	 *
	 * @return the id employee
	 */
	public Long getIdEmployee() {
		return idEmployee;
	}

	/**
	 * Sets the id employee.
	 *
	 * @param idEmployee the new id employee
	 */
	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the second name.
	 *
	 * @return the second name
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * Sets the second name.
	 *
	 * @param secondName the new second name
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * Gets the phonenumber.
	 *
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * Sets the phonenumber.
	 *
	 * @param phonenumber the new phonenumber
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * Gets the type employee.
	 *
	 * @return the type employee
	 */
	public String getTypeEmployee() {
		return typeEmployee;
	}

	/**
	 * Sets the type employee.
	 *
	 * @param typeEmployee the new type employee
	 */
	public void setTypeEmployee(String typeEmployee) {
		this.typeEmployee = typeEmployee;
	}

	/**
	 * Checks if is disponibilty.
	 *
	 * @return true, if is disponibilty
	 */
	public boolean isDisponibilty() {
		return disponibilty;
	}

	/**
	 * Sets the disponibilty.
	 *
	 * @param disponibilty the new disponibilty
	 */
	public void setDisponibilty(boolean disponibilty) {
		this.disponibilty = disponibilty;
	}

	/**
	 * Gets the call answered.
	 *
	 * @return the call answered
	 */
	public List<CallsAnswered> getCallAnswered() {
		return callAnswered;
	}

	/**
	 * Sets the call answered.
	 *
	 * @param callAnswered the new call answered
	 */
	public void setCallAnswered(List<CallsAnswered> callAnswered) {
		this.callAnswered = callAnswered;
	}

}
