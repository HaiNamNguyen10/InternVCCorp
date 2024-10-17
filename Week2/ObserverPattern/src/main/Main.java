package main;

public class Main {
	public static void main(String argc[]) {
		Subject subject = new Subject ();
		
		Observer observer1 = new Observer() {
			public void update(String message) {
				System.out.println("Observer 1 changed: "+ message);
			}
		};
		
		
		Observer observer2 = new Observer() {
			public void update(String message) {
				System.out.println("Observer 2 changed: "+ message);
			}
		};
		
		subject.attach(observer1);
		subject.attach(observer2);
		
		subject.notifyChange("First time changed");
		subject.detach(observer2);
		
		subject.notifyChange("Second time changed");
	}
	
}
