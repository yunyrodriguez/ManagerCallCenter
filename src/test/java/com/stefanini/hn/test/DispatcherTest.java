package com.stefanini.hn.test;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.stefanini.hn.mcc.Dispatcher;
import com.stefanini.hn.pool.MasterThread;
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
	//@Test
	public void xCall() {

		Date dateFirst = new Date();
		ArrayList<IncomingCalls> listCall = new ArrayList<IncomingCalls>();
		IncomingCalls call = new IncomingCalls(dateFirst, "9878-8798");
		listCall.add(call);
		IncomingCalls call2 = new IncomingCalls(dateFirst, "9878-8777");
		listCall.add(call2);
		IncomingCalls call3 = new IncomingCalls(dateFirst, "9878-8798");
		listCall.add(call3);
		IncomingCalls call4 = new IncomingCalls(dateFirst, "9878-8777");
		listCall.add(call4);
		IncomingCalls call5 = new IncomingCalls(dateFirst, "9878-8798");
		listCall.add(call5);
		IncomingCalls call6 = new IncomingCalls(dateFirst, "9878-8777");
		listCall.add(call6);
		IncomingCalls call7 = new IncomingCalls(dateFirst, "9878-8798");
		listCall.add(call7);
		IncomingCalls call8 = new IncomingCalls(dateFirst, "9878-8777");
		listCall.add(call8);
		IncomingCalls call9 = new IncomingCalls(dateFirst, "9878-8798");
		listCall.add(call9);
		IncomingCalls call10 = new IncomingCalls(dateFirst, "9878-8777");
		listCall.add(call10);

		MasterThread master = new MasterThread(listCall);
		master.start();
	}
	
	@Test
	public void Call() {

		Date dateFirst = new Date();
		IncomingCalls call = new IncomingCalls(dateFirst, "9878-8798");
		Dispatcher dispatcher = new Dispatcher(call);
		dispatcher.dispatchCall(call);
		
	}
}
