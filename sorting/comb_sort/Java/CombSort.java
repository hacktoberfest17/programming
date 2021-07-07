package algorithms;

import java.util.Scanner;

/**
 * @author juliobguedes
 * 
 * The algorithm is an improvement made to BubbleSort.
 * It works with a gap value that updates itself over
 * each iteration. This gap value works as a way to
 * avoid a great number of comparations that Bubble
 * Sort would've made. Please check out the execution
 * gif @ Wikipedia.
 *
 * @param <T> means Generic comparable types 
 */
public class CombSort<T extends Comparable<T>> {
	
	public static void main(String[] args) {
		Scanner rdr = new Scanner(System.in);
		
		@SuppressWarnings("unused")
		int uselessNumber = rdr.nextInt();rdr.nextLine();
		
		String[] input = rdr.nextLine().split(" ");
		Integer[] numberInput = toIntegerArray(input);
		
		CombSort<Integer> bub = new CombSort<Integer>();
		bub.sort(numberInput);
		
		System.out.println(bub.toString(numberInput));
		
		rdr.close();
	}

	private String toString(Integer[] numberInput) {
		String ret = "";
		
		for (int i = 0; i < numberInput.length; i++) {
			ret += numberInput[i];
			if (i != numberInput.length-1)
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
		int gap = array.length;
		boolean swapped = true;
		
		while (gap > 1 || swapped) {
			if (gap > 1) {
				gap = (int) (gap / 1.247330950103979);
			}
			
			int index = 0;
			swapped = false;
			
			while (index + gap < array.length) {
				
				if (array[index].compareTo(array[index+gap]) > 0) {
					swap(array, index, index+gap);
					swapped = true;
				}
				index++;
			}
			
			
		}
	}

	public void swap(T[] array, int indexA, int indexB) {
		T aux = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = aux;
	}


}
