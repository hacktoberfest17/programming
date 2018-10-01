package cc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class sortGame {

	static class pair {
		pair(String nam, int sal) {
			name = new String(nam);
			salary = sal;
		}

		String name;
		int salary;

	}

	static class Sortbysalary implements Comparator<pair> {

		@Override
		public int compare(pair o1, pair o2) {
			int rv;
			rv = o1.salary - o2.salary;
			if (rv == 0) {
				rv = Sortbyname();
			}

			return rv;
		}

		public static int rv;

		private int Sortbyname() {
			// final int rv;
			final class Sortbyname implements Comparator<pair> {

				@Override
				public int compare(pair o1, pair o2) {
					rv = o1.name.compareTo(o2.name);
					return rv;
				}
			}
			return rv;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String nam;
		int sal;

		int n = scan.nextInt();
		pair[] arr = new pair[n];
		ArrayList<pair> list = new ArrayList<>();

		for (int i = 0; i < n; ++i) {

			sal = scan.nextInt();
			nam = scan.next();
			pair a = new pair(nam, sal);
			list.add(a);

		}

		Collections.sort(list, new Sortbysalary()); 

		for (int i = 0; i < n; ++i) {
			System.out.println(list.get(i).name + "\t" + list.get(i).salary);
		}
	}

}
//collections for arraylist , if want to use for array , use ARRAYS