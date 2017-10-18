using System;
using System.Collections;

public class prime_factors
{
	public static int[] PrimeFactors(int num)
	{
		ArrayList primeFactors = new ArrayList();
		for (int i = 2; i <= Math.Sqrt(num); i++)
		{
			while (n % i == 0)
			{
				primeFactors.Add(i);
				n /= i;
			}
		}
		if (n > 2)
			primeFactors.Add(n);
		return (int[])primeFactors.ToArray(typeof(int));
	}

	static void Main(string[] args)
	{
		int[] factors = PrimeFactors(36);
		foreach (int i in factors)
			Console.Write(i + " ");
	}
}
