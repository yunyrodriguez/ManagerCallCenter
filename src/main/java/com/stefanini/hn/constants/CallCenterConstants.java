package com.stefanini.hn.constants;

/**
 * CallCenterConstants.
 *
 * @author Yuny Rene Rodriguez Perez <mailto: yrperez@stefanini.com />
 * @version 
 * @see 
 * @since 01-22-2019 03:22:55 PM 2019
 */
public class CallCenterConstants {

	/** Attribute that determine a Constant of SCHEME. */
	public final static String SCHEME = "callcenterdb";
	
	/** Attribute that determine a Constant of SCRIPT_EMPLOYEES. */
	public final static String SCRIPT_EMPLOYEES = "Select a From Employee a";
	
	/** Attribute that determine a Constant of SCRIPT_SAVE_CALL. */
	public final static String SCRIPT_SAVE_CALL = "Select a from IncomingCalls a where a.duration = :duration and  a.phoneNumber = :phoneNumber";
	
	/** Attribute that determine a Constant of DURATION. */
	public final static String DURATION = "duration";
	
	/** Attribute that determine a Constant of PHONE_NUMBER. */
	public final static String PHONE_NUMBER = "phoneNumber";
	
	/** Attribute that determine a Constant of CALL_ID. */
	public final static String CALL_ID = "callId";
	
	/** Attribute that determine a Constant of EMPLOYEE_ID. */
	public final static String EMPLOYEE_ID = "employeeId";
	
	/** Attribute that determine a Constant of CONSTANT_EMPLOYEE. */
	public final static String CONSTANT_EMPLOYEE = "employee";
	
	/** Attribute that determine a Constant of TYPE_OPERATOR. */
	public final static String TYPE_OPERATOR = "operator";
	
	/** Attribute that determine a Constant of TYPE_SUPERVISOR. */
	public final static String TYPE_SUPERVISOR = "supervisor";
	
	/** Attribute that determine a Constant of TYPE_DIRECTOR. */
	public final static String TYPE_DIRECTOR = "director";
	
	/** Attribute that determine a Constant of FORMAT_DATE. */
	public final static String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	/** Attribute that determine a Constant of KEEP_ALIVE. */
	public final static String KEEP_ALIVE = "200";

}
