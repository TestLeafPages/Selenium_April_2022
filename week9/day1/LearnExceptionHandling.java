package week9.day1;

public class LearnExceptionHandling {

	public static void main(String[] args) {
		int x = 10;

		int y = 0;

		int[] vals = { 10, 20, 30 };

		try {

			System.out.println(x / y);
			
			try {
				System.out.println(vals[3]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e);
			}
			
		} catch (ArithmeticException e) {
			System.out.println(x);
		} 

		System.out.println("End of program");

	}

}
