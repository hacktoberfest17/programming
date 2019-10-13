package allOne;

public class Sum {

	public static double arithmeticSumGivenStart() {
		double startNum = Input.input("What number does it start on?");
		double cmnDif = Input.input("What is the common difference?");
		double endIndex = Input.input("What is the end index?");
		double endNum = 0;
		double progressNum = startNum;
		System.out.println("1:\t" + startNum);
		for (int i = 0; i < (endIndex - 1); i++) {
			progressNum += cmnDif;
			endNum += progressNum;
			System.out.println((i + 2) + ":\t" + endNum);
		}
		return endNum;
	}

	public static double arithmeticSumGivenEquation() {
		// n/2(a[1] + a[lastIndex])
		double finalIndex = Input.input("What is the final index?");
		double firstNum = Input.input("What is the first number of the set?");
		double cmnDif = Input.input("What is the common difference?");
		double lastNum = subArithmeticCounter(finalIndex, firstNum, cmnDif);
		double answer = ((finalIndex / 2) * (firstNum + lastNum));
		return answer;
	}

	private static double subArithmeticCounter(double finalIndex, double firstNum, double cmnDif) {
		double answer = firstNum;
		for (int i = 0; i < (finalIndex - 1); i++) {
			answer = answer + cmnDif;
		}
		return answer;
	}

	public static double arithmeticSumGivenStartEnd() {
		double startNum = Input.input("What is the starting number?");
		double endNum = Input.input("What is the ending number?");
		double cmnDif = Input.input("What is the common difference?");
		double answer = 0;
		while (startNum <= endNum) {
				answer += startNum;
				startNum += cmnDif;
		}
		return answer;
	}

	public static double geometricSumGivenStart() {
		double startNum = Input.input("What is the starting number?");
		double cmnRat = Input.input("What is the common ratio?");
		double lastIndex = Input.input("What is the last index?");
		double answer = 0;
		for(int i = 0; i < lastIndex; i++) {
			answer += startNum;
			startNum *= cmnRat;
		}
		return answer;
	}

	public static double geometricSumGivenEquation() {
		// a[n]=a[1]r[n-1]		
		double firstNum = Input.input("What is the first number?");
		double cmnRat = Input.input("What is the common ratio?");
		double lastIndex = Input.input("What is the last index?");
		double answer = firstNum * (Math.pow(cmnRat, (lastIndex-1)));
		return answer;
	}

	public static double geometricSumGivenStartEnd() {
		double startNum = Input.input("What is the starting number?");
		double endNum = Input.input("What is the ending number?");
		double cmnDif = Input.input("What is the common ratio?");
		double answer = 0;
		while (startNum <= endNum) {
				answer += startNum;
				startNum *= cmnDif;
		}
		return answer;
	}

}
