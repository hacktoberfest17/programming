package cc;

import java.util.Scanner;

public class gradeStudents {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] grades = new int[n];
		for (int grades_i = 0; grades_i < n; grades_i++) {
			grades[grades_i] = in.nextInt();
		}
		int[] result = solve(grades);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		System.out.println("");
		in.close();

	}

	private static int[] solve(int[] grades) {
		for (int i = 0; i < grades.length; ++i) {
			if (grades[i] < 38 || grades[i] % 5 < 3)
				continue;
			else
				grades[i] += 5-(grades[i] % 5);
		}

		return grades;
	}

}
