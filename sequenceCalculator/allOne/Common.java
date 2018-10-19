package allOne;

public class Common {

	public static double arithmeticCommonDifferenceFind() {
		double numOne = Input.input("What is the first given number: ");
		double numOneSeq = Input.input("What number is that in terms of the sequence: ");
		double numTwo = Input.input("What is the second given number: ");
		double numTwoSeq = Input.input("What number is that in terms of the sequence");
		return arithmeticMath(numOneSeq, numTwoSeq, numOne, numTwo);
	}
	
	private static double arithmeticMath(double numOneSeq, double numTwoSeq, double numOne, double numTwo) {
		double seqDif = numTwoSeq - numOneSeq;
		double stepOne = numTwo - numOne;
		double stepTwo = stepOne / seqDif;
		return stepTwo;
	}

	public static double geometricCommonDifferenceFind() {
		//a[n] = a[1]r[n-1]
		double numOne = Input.input("What is the first given number: ");
		double numOneSeq = Input.input("What number is that in terms of the sequence: ");
		double numTwo = Input.input("What is the second given number: ");
		double numTwoSeq = Input.input("What number is that in terms of the sequence");
		return geometricMath(numOne, numOneSeq, numTwo, numTwoSeq);
	}
	
	private static double geometricMath(double numOne, double numOneSeq, double numTwo, double numTwoSeq) {
		double finalSeq = numTwoSeq - numOneSeq;
		double finalNumTwo = numTwo / numOne;
		double answer = Math.pow(finalNumTwo, (1/finalSeq));
		return answer;
	}

}
