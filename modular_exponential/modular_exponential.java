public class modular_exponential {

	public static int modularExponential(int base, int power, int modulus) {

		if (base > modulus)
			base %= modulus;

		int result = 1;

		while (power > 0) {
			if (power % 2 == 1)
				result = (result * base) % modulus;
			power = power >> 1;
			base = (base * base) % modulus;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(modularExponential(24, 2015, 1000));
	}
}
