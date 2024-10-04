package main;

public class Tiger extends Animal implements Hunt {
	public Tiger(String a) {
		super(a);
	}
	
	public void makeNoise() {
		System.out.println(this.getName() + "says roar");
	}
	
	public void hunt() {
		System.out.println(this.getName() + " is hunting");
	}
}
