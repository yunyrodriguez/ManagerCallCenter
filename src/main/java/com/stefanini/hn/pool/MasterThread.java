package com.stefanini.hn.pool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.stefanini.hn.util.IncomingCalls;

/**
 * MasterThread.
 *
 * @author Yuny Rene Rodriguez Perez <mailto: yrperez@stefanini.com />
 * @version 
 * @see 
 * @since 02-04-2019 12:25:34 PM 2019
 */
public class MasterThread extends Thread implements Serializable {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Attribute that determine call. */
	private final ArrayList<IncomingCalls> call;

	/** Attribute that determine executorService. */
	private final ThreadPoolExecutor executorService;

	/** Attribute that determine workingQueue. */
	private final BlockingQueue<Runnable> workingQueue;

	/**
	 * Instantiates a new master thread.
	 *
	 * @param listCall the list call
	 */
	public MasterThread(ArrayList<IncomingCalls> listCall) {
		super();
		this.call = listCall;
		this.workingQueue = new ArrayBlockingQueue<Runnable>(10);
		this.executorService = new ThreadPoolExecutor(this.call.size(), this.call.size(), 200, TimeUnit.MILLISECONDS, this.workingQueue);
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		try {

			for (int a = 0; a < this.call.size(); a++) {
				validateResponse(call.get(a));
			}
			Thread.sleep(200);
		} catch (Exception e) {
			if (e instanceof InterruptedException) {

			}
		}

		this.executorService.shutdown();
	}

	/**
	 * Validate response.
	 *
	 * @param response the response
	 */
	private void validateResponse(final IncomingCalls response) {

		final WorkerThread worker = new WorkerThread(response);
		this.executorService.submit(worker);

	}

	/**
	 * Gets the executor service.
	 *
	 * @return the executor service
	 */
	public ThreadPoolExecutor getExecutorService() {
		return executorService;
	}
}
