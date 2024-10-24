package main;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static final int NUM_THREAD = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ab sm = new SharedMemory();
		
		ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);
		
		for (int i = 1; i <= 2; i++) {
			Runnable worker = new CounterTask(sm);
			executor.execute(worker);
		}

		executor.shutdown();
		
		while (!executor.isTerminated()) {
		}
		
		
		System.out.println(sm.getCount());
	}

}
