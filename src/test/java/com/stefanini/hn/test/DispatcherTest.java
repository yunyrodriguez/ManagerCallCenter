package com.stefanini.hn.test;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import com.stefanini.hn.mcc.Dispatcher;
import com.stefanini.hn.test.AbstractTest;
import com.stefanini.hn.util.IncomingCalls;

public class DispatcherTest extends AbstractTest{

	@Test
	public void entityManagerFactoryOK() {
		
		assertNotNull(emf);
	}
	
	@Test
	public void entityManagerOK() {
		
		assertNotNull(em);
	}
	@Test
	public void xCall() {

		Date dateFirst = new Date();
		IncomingCalls call = new IncomingCalls(dateFirst, "9878-8798");
		IncomingCalls call2 = new IncomingCalls(dateFirst, "9878-8777");

		Dispatcher dispatcher2 = new Dispatcher(call2);
		Dispatcher dispatcher = new Dispatcher(call);
		dispatcher2.dispatchCall(call);
		//dispatcher.dispatchCall(call2);

	}
}
