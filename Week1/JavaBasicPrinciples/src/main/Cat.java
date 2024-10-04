package main;

public class Cat extends Animal implements Pet  {
	public Cat(String a) {
		super(a);
	}
	
	@Override public void makeNoise() {
		System.out.println("meow");
	}
	@Override public void beFriendly() {
		System.out.println(this.getName() + " is friendly");
	}
	@Override public void play() {
		System.out.println(this.getName() + " is playing..");
	}
}
