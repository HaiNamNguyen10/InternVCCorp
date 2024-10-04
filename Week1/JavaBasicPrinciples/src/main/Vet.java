package main;

public class Vet {
	private String name;
	
	public Vet(String a) {
		this.name = a;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void inject(Animal a) {
		a.makeNoise();
	}
	public static void main(String argc[]) {
		Vet vet1 = new Vet("Nam");
		Dog dog1 = new Dog("dog1");
		vet1.inject(dog1);
	}
}
