package main;

public class Bird extends Animal {
	public Bird(String a){
		super(a);
	}
	
	public void makeNoise() {
		System.out.println(this.getName() + " says Tweet");
	}
}
