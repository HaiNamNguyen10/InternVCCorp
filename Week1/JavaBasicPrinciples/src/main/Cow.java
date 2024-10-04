package main;

public class Cow extends Animal {
	private static int count = 0;
	
	public Cow(String a) {
		super(a);
		count++;
	}
	
	@Override public void makeNoise() {
		System.out.println("Moooo...");
	}
	
	public static int getNumCows(){
		return count;
	}
	
}
