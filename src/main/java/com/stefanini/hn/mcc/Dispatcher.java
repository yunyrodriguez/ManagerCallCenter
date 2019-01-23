package com.stefanini.hn.mcc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.stefanini.hn.util.Employee;
import com.stefanini.hn.util.IncomingCalls;
import com.stefanini.hn.constants.CallCenterConstants;
import com.stefanini.hn.persistence.ManagerPersistence;

/**
 * Dispatcher.
 *
 * @author Yuny Rene Rodriguez Perez <mailto: yrperez@stefanini.com />
 * @version 
 * @see 
 * @since 01-22-2019 03:22:27 PM 2019
 */
public class Dispatcher {

	/** Attribute that determine call. */
	private IncomingCalls call;

	/**
	 * Instantiates a new dispatcher.
	 *
	 * @param call the call
	 */
	public Dispatcher(IncomingCalls call) {
		this.call = call;
	}

	/** Attribute that determine ManagerPersistence. */
	private static ManagerPersistence managerPersistence = new ManagerPersistence();

	/**
	 * Dispatch call.
	 *
	 * @param call the call
	 */
	public static void dispatchCall(IncomingCalls call) {

		Date date = new Date();
		managerPersistence.insertIncomingCalls(call, call.getDuration());
		IncomingCalls processedCall = managerPersistence.obtainingSaveCall(call.getDuration(), call.getPhoneNumber());
		int flag = 0;
		int delayTime = (int) (Math.random() * numberLimit()) + numberLimit() - 10;

		delayProcess(delayTime);
		if (date.before(timerCall(processedCall.getDuration(), (6 + (delayTime / 1000))))) {
			flag = processManager(CallCenterConstants.TYPE_OPERATOR, managerPersistence.listEmployees(), processedCall,
					(6 + (delayTime / 1000)));
		}
		date = new Date();
		delayProcess(delayTime);
		if (date.before(timerCall(processedCall.getDuration(), (8 + (delayTime / 1000)))) && flag == 0) {
			flag = processManager(CallCenterConstants.TYPE_SUPERVISOR, managerPersistence.listEmployees(), processedCall,
					(8 + (delayTime / 1000)));
		}
		date = new Date();
		delayProcess(delayTime);
		if (date.before(timerCall(processedCall.getDuration(), (10 + (delayTime / 1000)))) && flag == 0) {
			flag = processManager(CallCenterConstants.TYPE_DIRECTOR, managerPersistence.listEmployees(), processedCall,
					(10 + (delayTime / 1000)));
		}

		if (flag == 0) {

			managerPersistence.insertCallLost(processedCall);
		}
	}

	/**
	 * Timer call.
	 *
	 * @param call the call
	 * @param time the time
	 * @return the date
	 */
	private static Date timerCall(Date call, int time) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(call);
			calendar.add(Calendar.SECOND, time);
			Date dateOut = calendar.getTime();
			DateFormat dateFormat = new SimpleDateFormat(CallCenterConstants.FORMAT_DATE);
			String fechaFinal = dateFormat.format(dateOut);

			Date convertDate = dateFormat.parse(fechaFinal);
			return convertDate;
		} catch (ParseException e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Processor call.
	 *
	 * @param call the call
	 * @param employeeType the employee type
	 * @param employee the employee
	 * @return the int
	 */
	private static int processorCall(IncomingCalls call, String employeeType, List<Employee> employee) {

		int count = 0;
		for (Employee employeeDisponibilty : employee) {
			if (employeeDisponibilty.getTypeEmployee().equals(employeeType) && employeeDisponibilty.isDisponibilty()) {

				Date date = new Date();
				managerPersistence.insertCallsAnswered(call, date, employeeDisponibilty);
				managerPersistence.modifyDisponibility(employeeDisponibilty);

				System.out.println("LLAMADA CONSTESTADA");
				System.out.println(employeeDisponibilty.getTypeEmployee() + ": " + employeeDisponibilty.getFirstName()
						+ " " + employeeDisponibilty.getSecondName());

				count = 1;
				return count;
			}
		}
		return count;

	}

	/**
	 * Process manager.
	 *
	 * @param employeeType the employee type
	 * @param employee the employee
	 * @param call the call
	 * @param number the number
	 * @return the int
	 */
	public static int processManager(String employeeType, List<Employee> employee, IncomingCalls call, int number) {
		int result = processorCall(call, employeeType, employee);
		Date date = new Date();
		if (result == 0) {
			do {
				result = processorCall(call, employeeType, employee);
				date = new Date();
			} while (date.before(timerCall(call.getDuration(), number)) && result == 0);
		}
		return result;
	}

	/**
	 * Delay process.
	 *
	 * @param time the time
	 */
	private static void delayProcess(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Number limit.
	 *
	 * @return the int
	 */
	private static int numberLimit() {
		int delayTime = (int) (Math.random() * 1000) + 500;
		return delayTime;
	}

	/**
	 * Gets the call.
	 *
	 * @return the call
	 */
	public IncomingCalls getCall() {
		return call;
	}

	/**
	 * Sets the call.
	 *
	 * @param call the new call
	 */
	public void setCall(IncomingCalls call) {
		this.call = call;
	}

}
