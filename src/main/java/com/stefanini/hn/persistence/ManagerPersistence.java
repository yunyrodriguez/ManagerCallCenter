package com.stefanini.hn.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.stefanini.hn.controller.CallLost;
import com.stefanini.hn.controller.CallsAnswered;
import com.stefanini.hn.util.Employee;
import com.stefanini.hn.util.IncomingCalls;
import com.stefanini.hn.constants.CallCenterConstants;

/**
 * ManagerPersistence.
 *
 * @author Yuny Rene Rodriguez Perez <mailto: yrperez@stefanini.com />
 * @version 
 * @see 
 * @since 01-22-2019 03:22:50 PM 2019
 */
public class ManagerPersistence {

	/** Attribute that determine factory. */
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory(CallCenterConstants.SCHEME);
	
	/** Attribute that determine manager. */
	private EntityManager manager = factory.createEntityManager();

	/**
	 * Insert calls answered.
	 *
	 * @param incomingCalls the incoming calls
	 * @param date the date
	 * @param employee the employee
	 */
	public void insertCallsAnswered(IncomingCalls incomingCalls, Date date, Employee employee) {

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.persist(new CallsAnswered(incomingCalls, date, employee));
		tx.commit();

	}

	/**
	 * Insert incoming calls.
	 *
	 * @param incomingCalls the incoming calls
	 * @param date the date
	 */
	public void insertIncomingCalls(IncomingCalls incomingCalls, Date date) {

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		manager.persist(new IncomingCalls(date, incomingCalls.getPhoneNumber()));
		tx.commit();
	}

	/**
	 * Insert call lost.
	 *
	 * @param incomingCalls the incoming calls
	 */
	public void insertCallLost(IncomingCalls incomingCalls) {

		EntityTransaction tx = manager.getTransaction();
		Date dateTimeout = new Date();
		tx.begin();

		manager.persist(new CallLost(incomingCalls, dateTimeout));
		tx.commit();

	}

	/**
	 * List employees.
	 *
	 * @return the list
	 */
	public List<Employee> listEmployees() {

		List<Employee> resultList = manager.createQuery(CallCenterConstants.SCRIPT_EMPLOYEES, Employee.class)
				.getResultList();
		return resultList;
	}

	/**
	 * Obtaining save call.
	 *
	 * @param duration the duration
	 * @param phoneNumber the phone number
	 * @return the incoming calls
	 */
	public IncomingCalls obtainingSaveCall(Date duration, String phoneNumber) {

		Query query = manager.createQuery(CallCenterConstants.SCRIPT_SAVE_CALL);
		query.setParameter(CallCenterConstants.DURATION, duration);
		query.setParameter(CallCenterConstants.PHONE_NUMBER, phoneNumber);
		IncomingCalls incomingCall = (IncomingCalls) query.getSingleResult();

		return incomingCall;
	}

	/**
	 * Modify disponibility.
	 *
	 * @param employee the employee
	 */
	public void modifyDisponibility(Employee employee) {

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Employee anEmployee = manager.find(Employee.class, employee.getIdEmployee());
		anEmployee.setDisponibilty(false);
		manager.persist(anEmployee);
		tx.commit();
		
	}

}
