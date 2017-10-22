public class babylonian_square_root {

	public static double squareRoot(double num) {
		double x = num;
		double y = 1;
		double e = 0.00000001;

		while (x - y > e) {
			x = (x + y) / 2;
			y = num / x;
		}
		return x;
	}

	public static void main(String[] args) {
		System.out.println(squareRoot(15));
	}
}
