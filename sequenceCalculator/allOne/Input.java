package allOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static double input(String prompt) {
		boolean isNotValid = true;
		Double num = null;
		do {
			System.out.println(prompt);
			try {

				num = Double.parseDouble(in.readLine());
			} catch (IOException ex) {
				System.out.println("Please Input a value");
				num = null;
			} catch (NumberFormatException nfe) {
				System.out.println("That isnt a number.");
				num = null;
			}
			if (num != null) {
				isNotValid = false;
			}
		} while (isNotValid);
		return num;
	}
}
