package algorithms;

import java.util.Scanner;
/**
 * @author juliobguedes
 * 
 * Gnome sort is a sorting algorithm that can
 * be compared with BubbleSort and InsertionSort.
 * The execution of the algorithm starts at the 
 * second element of the array: if the element
 * is smaller then the first one, they swap; if
 * not, the position variable is incremented and
 * third element is compared to the second, looping
 * over and over. The description of the algorithm
 * can be seen at Wikipedia, with a demonstrative 
 * table.
 * 
 * @param <T> means Generic comparable types
 */
public class GnomeSort<T extends Comparable<T>> {

	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);

		@SuppressWarnings("unused")
		int uselessNumber = rdr.nextInt();
		rdr.nextLine();

		String[] input = rdr.nextLine().split(" ");
		Integer[] numberInput = toIntegerArray(input);

		GnomeSort<Integer> bub = new GnomeSort<Integer>();
		bub.sort(numberInput);

		System.out.println(bub.toString(numberInput));

		rdr.close();
	}

	private String toString(Integer[] numberInput) {
		String ret = "";

		for (int i = 0; i < numberInput.length; i++) {
			ret += numberInput[i];
			if (i != numberInput.length - 1)
				ret += " ";
		}

		return ret;
	}

	private static Integer[] toIntegerArray(String[] input) {
		Integer[] array = new Integer[input.length];
		for (int i = 0; i < input.length; i++) {
			array[i] = Integer.parseInt(input[i]);
		}
		return array;
	}

	public void sort(T[] array) {
		if (array.length > 1) {
			int i = 1;

			while (i < array.length) {
				if (array[i].compareTo(array[i - 1]) < 0) {
					swap(array, i, i - 1);
					if (i != 1) {
						i--;
					}
					
				} else {
					i++;
				}

			}

		}
	}

	public void swap(T[] array, int indexA, int indexB) {
		T aux = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = aux;
	}

}
