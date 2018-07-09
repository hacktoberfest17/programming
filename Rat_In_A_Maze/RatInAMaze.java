import java.lang.reflect.Array;
import java.util.ArrayList;

public class RatInAMaze {

	public static void main(String[] args) {

		printMazePath(0, 0, 2, 2,"");//input number as per ur demand 
		System.out.println("Count  : "+countMazePath);

	}

	public static void printMazePath(int sr, int sc, int dr, int dc, String s) {
		if (sr == dr && sc == dc) {
			System.out.println(s);
			return;
		}
		if (sc <= dc)
			printMazePath(sr, sc + 1, dr, dc, s + "H");
		if (sr <= dr)
			printMazePath(sr + 1, sc, dr, dc, s + "V");
	}


	public static int countMazePath(int sr, int sc, int dr, int dc) {
		if (sr == dr && sc == dc) {

			return 1;
		}

		int count = 0;

		if (sc <= dc) {

			count += countMazePath(sr, sc + 1, dr, dc);
		}
		if (sr <= dr) {

			count += countMazePath(sr + 1, sc, dr, dc);
		}

		return count;
	}
}
