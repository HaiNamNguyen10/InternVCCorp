package main;

public class MyThread implements Runnable{
	
	//private static int count  = 0;
	public void  run() {
		System.out.println("New thread starts");
		for (int i  = 1; i <= 50; i++) {
			System.out.println(Thread.currentThread().getName() + " printed " + i);
			//count+=1;
			try {
	            Thread.sleep(50);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		//System.out.println(count);
	}
	 
	public static void main(String argc[]) {
		
		Thread myThread = new Thread(new MyThread());
		myThread.start();
		
		for (int i = 1; i <= 50; i++) {
			System.out.println(Thread.currentThread().getName()+ " printed " + i);
			//count+=1;
			
			try {
	            Thread.sleep(50);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		
		//System.out.println(count);
		System.out.println("Main thread closed");
	}
}
