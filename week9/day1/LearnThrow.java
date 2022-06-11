package week9.day1;

public class LearnThrow {

	public int divide(int num1, int num2) {
		int res;
		if( num1 > num2) {
			res = num1 / num2;
		}else {
			throw new ArithmeticException("Input is not valid");
		}
		
		return res;
	}

	public static void main(String[] args) {
		LearnThrow lt = new LearnThrow();

		int divide =0;
		try {
			divide = lt.divide(5, 10);
		} catch (Exception e) {
			divide = lt.divide(25, 5);
		}
		System.out.println(divide);

	}

}
