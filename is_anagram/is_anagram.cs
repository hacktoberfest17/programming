using System;

public class is_anagram
{
	public static bool isAnagram(string str1, string str2)
	{
		if (str1.Length != str2.Length)
			return false;

		int[] count1 = new int[256];
		int[] count2 = new int[256];

		for (int i = 0; i < str1.Length; i++)
		{
			++count1[str1[i]];
			++count2[str2[i]];
		}

		for (int i = 0; i < 256; i++)
			if (count1[i] != count2[i])
				return false;
		return true;
	}

	static void Main(string[] args)
	{
		bool anagram = isAnagram("LISTEN", "SILENT");

		if (anagram)
			Console.WriteLine("The strings are Anagram of each other");
		else
			Console.WriteLine("The strings are not Anagram of each other");
	}
}
