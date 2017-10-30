public class insertion_sort {

	public static void main(String[] args) {

          int[] arr = {12, 11, 13, 5, 6, 45, 99, 1, 654}; // Array to sort

          for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int key = arr[i];

			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}

          // Sorted Array
		for (int x: arr) {
			System.out.print(x + " ");
		}
	}
}
