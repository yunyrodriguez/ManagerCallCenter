package com.stefanini.hn.pool;

import com.stefanini.hn.mcc.Dispatcher;
import com.stefanini.hn.util.IncomingCalls;

public class WorkerThread implements Runnable {

	private final IncomingCalls call;

	public WorkerThread(IncomingCalls call) {
		super();
		this.call = call;
	}

	public void run() {

		Dispatcher.dispatchCall(call);

	}

}
