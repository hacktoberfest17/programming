class QuickSort {
	public static void main(String[] args) throws Exception {

		int quantity = 20;
		int[] vector = new int[quantity];

		for (int i = 0; i < vector.length; i++) {
			vector[i] = (int) (Math.random() * quantity);
		}

		System.out.println("Vector before QuickSort: ");
		for (int i = 0; i < vector.length ; i++ ) {
			System.out.print(vector[i] + "-");
		}

		long initialTime = System.currentTimeMillis();

		quickSort(vector, 0, vector.length - 1);

		long finalTime = System.currentTimeMillis();

		System.out.println(" ");
		System.out.println("Vector after quickSort: ");

		for (int i = 0; i < vector.length ; i++ ) {
			System.out.print(vector[i] + "-");
		}
		System.out.println(" ");
		System.out.println("Execution time = " + (finalTime - initialTime) + " ms");

	}

	private static void quickSort(int[] vector, int first, int last) {
		if (first < last) {
			int referencePosition = separar(vector, first, last);
			quickSort(vector, first, referencePosition - 1);
			quickSort(vector, referencePosition + 1, last);
		}
	}

	private static int separar(int[] vector, int first, int last) {
		int reference = vector[first];
		int i = first + 1, j = last;
		while (i <= j) {
			if (vector[i] <= reference)
				i++;
			else if (reference < vector[j])
				j--;
			else {
				int swap = vector[i];
				vector[i] = vector[j];
				vector[j] = swap;
				i++;
				j--;
			}
		}
		vector[first] = vector[j];
		vector[j] = reference;
		return j;
	}
}