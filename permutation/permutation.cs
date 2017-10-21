using System;

public class permutation
{
	public static long npr(int n, int r) {

		long ans = 1;
		if (r > n || n < 0 || r < 0)
			return -1;
		for (int i = n; i > n - r; i--)
			ans *= i;
		return ans;
	}

	static void Main(string[] args)
	{
		long permutation = npr(15, 5);
		if (permutation > 0)
			Console.WriteLine(permutation);
		else
			Console.WriteLine("Invalid Input");
	}
}
