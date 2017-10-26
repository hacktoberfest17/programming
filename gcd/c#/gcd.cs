using System;

public class gcd
{
	public static int GCD(int a, int b)
	{
		if (b == 0)
			return a;
		else 
			return GCD(b, a % b);
	}

	static void Main(string[] args)
	{
		Console.WriteLine(GCD(36, 6));
	}
}
