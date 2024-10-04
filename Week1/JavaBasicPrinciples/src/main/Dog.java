package main;

public class Dog extends Animal implements Pet {
	
	public Dog(String a) {
		super(a);
	}
	
	@Override public void makeNoise() {
		System.out.println("wolf wolf");
	}
	@Override public void beFriendly() {
		System.out.println(this.getName() + " is friendly");
	}
	
	@Override public void play() {
		System.out.println(this.getName() + " is playing..");
	}
}
