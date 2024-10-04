package fileInteracting;
import java.util.Scanner;
import java.io.*;
public class FileInteracting {
	public static String[] files;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//create a new folder
		File folder = new File("New Folder");
		//folder.mkdir();
		String path = folder.getAbsolutePath();
		System.out.println(path);
		//list all files of an folder
		
		System.out.println("All the files in this folder: ");
		int count = 0;
		if (folder.isDirectory()) {
			files = folder.list();
			
			for (String file : files) {
				System.out.println("   (" + ++count + ") " + file );
				
			}
		}
		while(true) {
			System.out.println("Choose the file to read, press 0 to end ");
			
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			
			if(option > count || option < 0) {
				System.out.println("invalid, please choose again");
			}
			else if (option == 0) {
				System.out.println("Terminated");
				input.close();
				break;
			}
			else {
				FileReader in = new FileReader(path + "/" + files[option-1]);
				
				try {
					int c = -1;
					while ((c = in.read()) != -1) {
						System.out.print((char)c);
					}
					System.err.println();
					in.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				finally {
				}
			}
			
		}

	}
}
