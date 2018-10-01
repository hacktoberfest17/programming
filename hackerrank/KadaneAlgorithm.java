package cc;

public class KadaneAlgorithm {

	public static void main(String[] args) {

		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

		System.out.println(Kadane(arr));
	}

	private static int Kadane(int[] arr) {
		int max_global = Integer.MIN_VALUE, max_current = 0;

		for (int i = 0; i < arr.length; ++i) {

			max_current = Math.max(arr[i], max_current + arr[i]);

			if (max_global < max_current) {
				max_global = max_current;
			}
		}

		return max_global;
	}

}
