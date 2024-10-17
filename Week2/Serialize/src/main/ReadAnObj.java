package main;
import java.io.*;
public class ReadAnObj {
	public static void main(String argc[]) {
		try {
			FileInputStream in = new FileInputStream("./src/output.txt");
			ObjectInputStream os = new ObjectInputStream(in);
			
			Object obj = os.readObject();
			GameCharacter z = (GameCharacter) obj;
			os.close();
			System.out.println("Successfully Deserialized!");
			System.out.println(z);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
