/**
 * Dice class used in the yahtzee game. It can display the number rolled
 * and have n number of sides.
 * @author Felipe Scrochio Custódio
 */
public class Dice {
	
	private int sides;
	private int result;

	/**
	 * Standard 6 sides dice constructor
	 */
	public Dice() {
		sides = 6;
	}

	/**
	 * n number of sides dice constructor
	 * @param  n Number of sides in the dice
	 */
	public Dice(int n) {
		sides = n;
	}

	/**
	 * Gets the last rolled result of this dice
	 * @return Last dice result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * Rolls the dice
	 * @return Number from 1 to n sides.
	 */
	public int roll() {
		Random r = new Random();
		result = Math.abs((r.getIntRand(sides)));
		result++; /* change min from 0 to 1 */
		return result;
	}

	/**
	 * Prints the last result of the dice
	 */
	public void display() {

		String d;
		if (sides == 6) {

			switch(result) {

				case 1:
					d = "+-----+\n|     |\n|  *  |\n|     |\n+-----+";
					System.out.print(d);
					
				case 2:
					d = "+-----+\n|    *|\n|     |\n|*    |\n+-----+";
					System.out.print(d);
					
				case 3:
					d = "+-----+\n|    *|\n|  *  |\n|*    |\n+-----+";
					System.out.print(d);
					
				case 4:
					d = "+-----+\n|*   *|\n|     |\n|*   *|\n+-----+";
					System.out.print(d);
					
				case 5:
					d = "+-----+\n|*   *|\n|  *  |\n|*   *|\n+-----+";
					System.out.print(d);
					
				case 6:
					d = "+-----+\n|*   *|\n|*   *|\n|*   *|\n+-----+";
					System.out.print(d);
			}

		} else {
			System.out.println("This type of dice can't be printed.");
		}
	}
}