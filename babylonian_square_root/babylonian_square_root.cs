using System;

public class babylonian_square_root
{
	public static double squareRoot(double num)
	{
		x = num;
		y = 1;
		e = 0.00000001;

		while (x - y > e)
		{
			x = (x + y) / 2;
			y = num / x;
		}
		return x;
	}

	static void Main(string[] args)
	{
		Console.WriteLine(squareRoot(15));
	}
}
