package com.stefanini.hn.pool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.stefanini.hn.util.IncomingCalls;

public class MasterThread extends Thread implements Serializable {

	private static final long serialVersionUID = 1L;

	private final ArrayList<IncomingCalls> call;

	private final ThreadPoolExecutor executorService;

	private final BlockingQueue<Runnable> workingQueue;

	public MasterThread(ArrayList<IncomingCalls> listCall) {
		super();
		this.call = listCall;
		this.workingQueue = new ArrayBlockingQueue<Runnable>(10);
		this.executorService = new ThreadPoolExecutor(this.call.size(), this.call.size(), 200, TimeUnit.MILLISECONDS, this.workingQueue);
	}

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
