package main;

public class SharedMemory extends Ab{
	
	private int count = 0;
	
	public synchronized void increment() {
		count++;
		System.out.println("Count inremented to " + count);
	}
	
	public synchronized int getCount() {
		return count;
	}
}
