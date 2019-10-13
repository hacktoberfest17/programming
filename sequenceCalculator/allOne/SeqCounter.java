package allOne;

public class SeqCounter {

	public static double arithmeticCounter() {
		double base = Input.input("Insert Base Number:");
		double answer = base;
		double common = Input.input("What is the common difference: ");
		double recur = Input.input("To what term: ");
		System.out.println("1:\t" + answer);
		for (int i = 0; i < (recur - 1); i++) {
			answer = answer + common;
			System.out.println((i + 2) + ":\t" + answer);
		}
		return answer;
	}

	public static double geometricCounter() {
		double base = Input.input("Insert Base Number:");
		double answer = base;
		double common = Input.input("What is the common difference: ");
		double recur = Input.input("To what term: ");
		System.out.println("1:\t" + answer);
		for (int i = 0; i < (recur - 1); i++) {
			answer = answer * common;
			System.out.println((i + 2) + ":\t" + answer);
		}
		return answer;
	}
}
