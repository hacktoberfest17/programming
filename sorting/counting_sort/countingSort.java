public class countingSort{
	public static void main(String[] args) {
		int[] unsorted = {0,1,94,1,68,28,8,2,5,8,2,8,2,5,6,6,7,9,9,9,5,2,2,34};

		System.out.println("Array before:");
		for(int i = 0; i < unsorted.length; i++) System.out.print(unsorted[i] + ", ");

		unsorted = countingSort(unsorted);

		System.out.println("\n\nArray after: ");
		for(int i = 0; i < unsorted.length; i++) System.out.print(unsorted[i] + ", ");

	}

	public static int[] countingSort(int[] arr) {
		int[] toReturn = new int[arr.length];

		int min = arr[0];
		int max = arr[0];

		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) min = arr[i];
			if(arr[i] > max) max = arr[i];
		}

		// Where we'll be storing the counts of our values.
		int[] count = new int[max - min + 1];

		// First loop populating our counts. 
		for(int i = 0; i < arr.length; i++) count[arr[i] - min]++;

		// Calculating the number of times each value occurs.
		count[0]--;
		for(int i = 1; i < count.length; i++) count[i] = count[i] + count[i-1];

		// Determining where we should put the value and how many times it should go there.
		for(int i = toReturn.length - 1; i >= 0; i--) {
			int index = count[arr[i] - min]--;
			toReturn[index] = arr[i];
		}

		return toReturn;
	}
}