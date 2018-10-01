package cc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class course {

	public static class student {
		int roll;
		int course;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList<student> list1 = new LinkedList<>();
		LinkedList<student> list2 = new LinkedList<>();
		LinkedList<student> list3 = new LinkedList<>();
		LinkedList<student> list4 = new LinkedList<>();
		LinkedList<student> result = new LinkedList<>();

		String str = "";

		int n = scan.nextInt();
		int dequeue = 0, priority = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			String s = scan.next();

			if (s.equals("E")) {
				student stud = new student();
				stud.course = scan.nextInt();
				if (!map.containsKey(stud.course)) {
					++priority;
					map.put(stud.course, priority);
				}
				stud.roll = scan.nextInt();
				if (stud.course == 1) {
					list1.addLast(stud);
				} else if (stud.course == 2) {
					list2.addLast(stud);

				} else if (stud.course == 3) {
					list3.addLast(stud);

				} else {
					list4.addLast(stud);

				}

			} else {
				++dequeue;
			}
		}

		ArrayList<Integer> priorityList = new ArrayList<>(map.keySet());

		int i = 0;
		for (int x : priorityList) {
			++i;
			if (x == i) {
				for (int j = 0; j < list1.size(); ++j) {
					result.addLast(list1.removeFirst());
				}
			}
			if (x == i) {
				for (int j = 0; j < list2.size(); ++j) {
					result.addLast(list2.removeFirst());
				}
			}
			if (x == i) {
				for (int j = 0; j < list3.size(); ++j) {
					result.addLast(list3.removeFirst());
				}
			}
			if (x == i) {
				for (int j = 0; j < list4.size(); ++j) {
					result.addLast(list4.removeFirst());
				}
			}
		}

		for (i = 0; i < dequeue; ++i) {
			student s = result.removeFirst();
			System.out.println(s.roll + " " + s.course);
		}

		scan.close();
	}

}
