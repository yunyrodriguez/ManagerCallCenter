package com.stefanini.hn.pool;

import com.stefanini.hn.mcc.Dispatcher;
import com.stefanini.hn.util.IncomingCalls;

/**
 * WorkerThread.
 *
 * @author Yuny Rene Rodriguez Perez <mailto: yrperez@stefanini.com />
 * @version 
 * @see 
 * @since 02-04-2019 12:25:27 PM 2019
 */
public class WorkerThread implements Runnable {

	/** Attribute that determine call. */
	private final IncomingCalls call;

	/**
	 * Instantiates a new worker thread.
	 *
	 * @param call the call
	 */
	public WorkerThread(IncomingCalls call) {
		super();
		this.call = call;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {

		Dispatcher.dispatchCall(call);

	}

}
