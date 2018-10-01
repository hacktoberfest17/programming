package cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CodeArenaKRK {
	static int countR = 0;
	static int countK = 0;

	public static void print(int n, String str, int vidx, int count) {
		if (count == n) {
			++countR;
			return;
		}
		if (vidx >= str.length()) {
			return;
		}
		print(n, str, vidx + 1, count);
		if (str.charAt(vidx) == 'R')
			print(n, str, vidx + 1, count + 1);
		else
			print(n, str, vidx + 1, count);

	}

	public static void print1(int n, String str, int vidx, int count) {
		if (count == n) {
			++countK;
			return;
		}
		if (vidx >= str.length()) {
			return;
		}
		print1(n, str, vidx + 1, count);
		if (str.charAt(vidx) == 'K')
			print1(n, str, vidx + 1, count + 1);
		else
			print1(n, str, vidx + 1, count);

	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = scan.nextInt();
		while (t > 0) {
			countR = 0;
			countK = 0;
			scan = new Scanner(System.in);
			int m = scan.nextInt();
			int n = scan.nextInt();
//			int m = reader.read();
//			int n = reader.read();
			
			String str = scan1.nextLine();
			
//			print(m, str, 0, 0);
//			print1(n, str, 0, 0);
			System.out.println(countR + " " + countK);
			--t;

		}
		scan.close();
		scan1.close();
	}

}
//2
//1 1
//RKRK
//2 1
//KRKRK