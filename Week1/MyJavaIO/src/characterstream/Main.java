package characterstream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//FileReader in = null;
		//FileWriter out = null;
		
		try {
			FileReader fr = new FileReader("input.txt");
			FileWriter fo = new FileWriter("output.txt");
			
			BufferedReader in = new BufferedReader(fr);
			BufferedWriter out = new BufferedWriter(fo);
			int c;
			while((c = in.read()) != -1) {
				out.write(c);
				System.out.println(c);
			}
			System.out.println("Success!");
			in.close();
			out.close();
		}
		finally {}
		
	}

}
