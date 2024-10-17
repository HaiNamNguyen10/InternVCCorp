package main;
import java.io.*;

public class Serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCharacter z = new GameCharacter("zombie", 100, "teeth");
		System.out.println(z);
		try {
			FileOutputStream file = new FileOutputStream("./src/output.txt");
			ObjectOutputStream os = new ObjectOutputStream(file);
			os.writeObject(z);
			os.close();
			System.out.println("Sucessfully Serialized!");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
