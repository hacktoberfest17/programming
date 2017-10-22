using System;

public class linear_search
{
	static void Main(string[] args)
	{
		int[] array = {13, 654, 48, 5, 186, 813, 81, 3};
		int index = -1, searchElement = 5;

		for (int i = 0; i < array.Length; i++)
		{
			if (array[i] == searchElement)
			{
				index = i;
				break;				
			}
		}
		if (index >= 0)
			Console.WriteLine(searchElement + " found at index " + index);
		else
			Console.WriteLine(searchElement + " not found in the given list");
	}	
}
