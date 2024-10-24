package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
	public static final int NUM_OF_THREAD = 5;

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(NUM_OF_THREAD);
		
		for (int i = 1; i <= 10; i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		}

		
		executor.shutdown();

		// Wait until all threads are finish
		while (!executor.isTerminated()) {
		}

		System.out.println("Finished all threads");
	}
}
