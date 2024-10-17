package main;
import java.util.ArrayList;
import java.util.Collections;
public class JavaArrayList {
	public static void main(String argc[]) {
		ArrayList<String> Animals = new ArrayList<String>();
		Animals.add("Dog"); // add an item to the last of an ArrayList
		Animals.add("Rhino");
		Animals.add("Cow");
		Animals.add("Lion");
		Animals.add(1,"Cat"); // add an item at a specified position
		Animals.add(1,"test"); // add an item at a specified position
				
		System.out.println(Animals.get(1)); //access an item through the index
		//Animals.set(1, "Dog"); // change an item through the index
		
		System.out.println(Animals.size()); // print the size of ArrayList
		Collections.sort(Animals); // sort an ArrayList alphabetically or numerically
		// loop through an ArrayList
		for(String Animal : Animals) {
			System.out.println(Animal);
		}
		Animals.remove(1); // remove the item at the second position
		Animals.clear(); // remove all items in ArrayList
		
		
	}
}
