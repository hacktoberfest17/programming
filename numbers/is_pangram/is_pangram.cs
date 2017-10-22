using System;

public class is_pangram
{
	public static bool isPangram(string str)
	{
		bool[] pangram = new bool[26];

		for (int i = 0; i < str.Length; i++)
		{
			if (str[i] >= 'A' && str[i] <= 'Z')
				pangram[str[i] - 'A'] = true;
			if (str[i] >= 'a' && str[i] <= 'z')
				pangram[str[i] - 'a'] = true;
		}

		for (int i = 0; i < 26; i++)
			if (!pangram[i])
				return false;

		return true;
	}

	static void Main(string[] args)
	{
		bool pangram = isPangram("The quick brown fox jumps over the lazy dog");

		if (pangram)
			Console.WriteLine("Given string is a pangram");
		else
			Console.WriteLine("Given string is not a pangram");
	}
}
