using System;
using System.Numerics;
using System.Collections.Generics;

public class Ackermann
{
	public static BigInteger ackermann(BigInteger m, BigInteger n)
	{
		Stack<BigInteger> stack = new Stack<BigInteger>();
		stack.Push(m);
		while (stack.Count != 0)
		{
			m = stack.Pop();
			if (m == 0)
				n = n + 1;
			else if (n == 0)
			{
				stack.Push(m - 1);
				n = 1;
			}
			else
			{
				stack.Push(m - 1);
				stack.Push(m);
				--n;
			}
		}
		return n;
	}

	static void Main(string[] args)
	{
		Console.WriteLine(ackermann(3, 4));
	}
}
