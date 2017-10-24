using System;

public class modular_exponential
{
	public static int modularExponential(int b, int power, int modulus)
	{
		if (b > modulus)
			b %= modulus;
		
		int result = 1;
		while (power > 0)
		{
			if (power % 2 == 1)
				result = (result * b) % modulus;
			power = power >> 1;
			b = (b * b) % modulus;
		}
		return result;
	}

	static void Main(string[] args)
	{
		Console.WriteLine(modularExponential(24, 2015, 1000));
	}
}
