package main;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class CheckedException {
	public static void main(String[] args) {
        File file = new File("example.txt");
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data); 
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();  
                }
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}
