package main;

public class CounterTask implements Runnable {
	private Ab sm;
	
	public CounterTask(Ab sm) {
		this.sm = sm;
	}
	
	public void run() {
		for (int i = 0; i < 100000; i++) {
			sm.increment();
		}
	}
}
