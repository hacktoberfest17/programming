using System;

public class BinarySearch
{
	static void Main(string[] args)
	{
		// Sorted Array
		int[] array = {1, 5, 9, 16, 33, 50, 67, 88};

		int start = 0, end = array.Length - 1; 
		int target = 16;
		int index = -1;
		while (start < end)
		{
			int middle = (start + end) / 2;
			if (array[middle] == target)
			{
				index = middle;
				break;
			}
			else if (array[middle] > target)
				end = middle - 1;
			else
				start = middle + 1;
		}

		if (index >= 0)
			Console.WriteLine(target + " found at index " + index);
		else
			Console.WriteLine(target + " not found");
	}
}
