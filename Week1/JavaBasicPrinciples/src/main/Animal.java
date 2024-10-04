package main;

public abstract class Animal implements MakeNoise{
	
	private String name;
	
	public Animal(String a) {
		this.name = a;
	}
	public String getName() {
		return this.name;
	}
	
	//public abstract void makeNoise();
}
