package main;

public class UncheckedException {
	public static double divide(int a, int b) {
		return a/b;
	}
	
	public static void main(String argc[]) {
		double x;
		try {
			x = divide(10,0);
			System.out.println(x);
		}
		catch(ArithmeticException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
