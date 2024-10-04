package javaBinary;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
//import java.nio.charset.StandardCharsets;
public class JavaBinary {
		
	private static final String file_name = "Lato-Regular.bin";
	private static final String output = "outputNew.txt";
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		byte[] buffer = new byte[1024];
		FileInputStream fis = new FileInputStream(file_name);
		FileOutputStream fos = new FileOutputStream(output);
		
		//FileOutputStream out = null;
		
		try {	
			int c = -1;
			while((c = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, c);
				for(byte x : buffer) {
					System.out.println(x);
				}
				
			}
			System.out.println("Success");
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		finally {
			fis.close();
			fos.close();
		}
		
		
	}

}
