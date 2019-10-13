package allOne;

public class MainMenu {

	static final int COUNTER_INDEX = 1;
	static final int SUM_START = 2;
	static final int SUM_EQUATION = 3;
	static final int SUM_START_END = 4;
	static final int COMMON_DIFFERENCE = 5;

	public static double mainMenuSelection() {
		final int ARITHMETIC_INDEX = 1;
		final int GEOMETRIC_INDEX = 2;
		final int SUMMATION_INDEX = 3;

		double answer = 0;
		int whatMenu = firstMenu();
		switch (whatMenu) {
		case ARITHMETIC_INDEX:
			answer = arithmeticMenu();
			break;
		case GEOMETRIC_INDEX:
			answer = geometricMenu();
			break;
		case SUMMATION_INDEX:
			answer = summationMenu();
			break;
		}
		return answer;
	}

	private static int firstMenu() {
		boolean isInvalidData = true;
		int sequence = 0;
		final int START_INDEX = 1;
		final int END_INDEX = 3;

		System.out.println("1.\t Arithmetic \n2.\t Geometric \n3.\t Summation");
		while (isInvalidData) {
			sequence = (int) Input.input("What type of sequence do you have?");
			if (sequence >= START_INDEX && sequence <= END_INDEX) {
				isInvalidData = false;
			}
		}
		return sequence;
	}

	private static double arithmeticMenu() {

		boolean isInvalidData = true;
		double answer = 0;
		menuList();
		while (isInvalidData) {
			int input = (int) Input.input("Enter your selection:");

			switch (input) {
			case COUNTER_INDEX:
				answer = SeqCounter.arithmeticCounter();
				break;
			case SUM_START:
				answer = Sum.arithmeticSumGivenStart();
				break;
			case SUM_EQUATION:
				answer = Sum.arithmeticSumGivenEquation();
				break;
			case SUM_START_END:
				answer = Sum.arithmeticSumGivenStartEnd();
				break;
			case COMMON_DIFFERENCE:
				answer = Common.arithmeticCommonDifferenceFind();
				break;
			}
			if (input >= COUNTER_INDEX && input <= COMMON_DIFFERENCE) {
				isInvalidData = false;
			}
		}
		return answer;
	}

	private static double geometricMenu() {

		boolean isInvalidData = true;
		double answer = 0;
		menuList();
		while (isInvalidData) {
			int input = (int) Input.input("Enter your selection");

			switch (input) {
			case COUNTER_INDEX:
				answer = SeqCounter.geometricCounter();
				break;
			case SUM_START:
				answer = Sum.geometricSumGivenStart();
				break;
			case SUM_EQUATION:
				answer = Sum.geometricSumGivenEquation();
				break;
			case SUM_START_END:
				answer = Sum.geometricSumGivenStartEnd();
				break;
			case COMMON_DIFFERENCE:
				answer = Common.geometricCommonDifferenceFind();
				break;
			}
			if (input >= COUNTER_INDEX && input <= COMMON_DIFFERENCE) {
				isInvalidData = false;
			}
		}
		return answer;
	}

	private static double summationMenu() {
		final int NON_RECURSIVE = 1;
		final int RECURSIVE = 2;

		boolean isInvalidData = true;
		double answer = 0;
		System.out.println("1.\tNon-Recursive \n2.\tRecursive");
		while (isInvalidData) {
			int input = (int) Input.input("Enter your selection");

			switch (input) {
			case NON_RECURSIVE:
				answer = Summation.nonRecursive();
				break;
			case RECURSIVE:
				answer = Summation.recursive();
			}
			if (input >= NON_RECURSIVE && input <= RECURSIVE) {
				isInvalidData = false;
			}
		}
		return answer;
	}

	private static void menuList() {
		System.out.println(
				"1.\tCounter \n2.\tSum Given Start \n3.\tSum Given Equation \n4.\tSum Given Start and End \n5.\tCommon Difference Finder");
	}

	public static void quitMenu() {
		System.out.println("1.\tContinue \n2.\tQuit");

	}
}
