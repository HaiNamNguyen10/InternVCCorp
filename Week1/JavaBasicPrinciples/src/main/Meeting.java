package main;

public class Meeting {
	public static void main(String argc[]) {
		Animal dog1 = new Dog("dog1");
		Animal cat1 = new Cat("cat1");
		Animal cow1 = new Cow("cow1");
		Animal cow2 = new Cow("cow2");
		
		dog1.makeNoise();
		cow1.makeNoise();
		
		
		
		//Vet vet1 = new Vet("Nam");
		//System.out.println(vet1.name);
		//vet1.inject(dog1);
	}
}
