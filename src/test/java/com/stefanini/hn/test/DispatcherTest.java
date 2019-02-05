package com.stefanini.hn.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.stefanini.hn.mcc.Dispatcher;
import com.stefanini.hn.pool.MasterThread;
import com.stefanini.hn.test.AbstractTest;
import com.stefanini.hn.util.IncomingCalls;

public class DispatcherTest extends AbstractTest {

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

		MasterThread master = new MasterThread(getList());
		master.start();
	}

	// @Test
	public void Call() {

		Date dateFirst = new Date();
		IncomingCalls call = new IncomingCalls(dateFirst, "9878-8798");
		Dispatcher dispatcher = new Dispatcher(call);
		dispatcher.dispatchCall(call);

	}

	public ArrayList<IncomingCalls> getList() {
		ArrayList<IncomingCalls> listCall = new ArrayList<IncomingCalls>();
		Date dateFirst = new Date();
		for (int i = 0; i < 10; i++) {
			IncomingCalls call = new IncomingCalls(dateFirst, "9878-874" + i);
			listCall.add(call);
		}
		return listCall;
	}
}
