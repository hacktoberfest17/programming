/**
* Handles the dice rolls for the yahtzee game
* Adapted code from university assignment
* @author Felipe Scrochio Custodio, Gabriel Scalici
*/
public class RollDice {
	
	Dice[] dices;

	/**
	* Creates and initializes several Dice objects
	* @param n Number of dices
	*/
	public RollDice(int n) {
		dices = new Dice[n];
		for (int i = 0; i < n; i++) {
			dices[i] = new Dice();
		}
	}

    /**
     * Rolls all dices.
     * @return Returns the result of every dice in the array
     */
    public int[] roll() {
		int[] results = new int[dices.length]; 
		/* Number de results = Number of dices */
		for (int i = 0; i < dices.length; i++) results[i] = dices[i].roll();
		return results;
	}

    /**
     * Rolls some of the dices.
     * @param whichDices - Array of booleans that indicates which dices to roll
     * Each position represents a dice in the dices array
     * @return Returns the result of every dice in the array
     */
    public int[] roll(boolean[] whichDices) {
		int[] results = new int[dices.length];
		for (int i = 0; i < dices.length; i++) {
			if (whichDices[i]) {
				results[i] = dices[i].roll();
			} else {
				results[i] = dices[i].getResult();
			}
		}
		return results;
	}

    /**
     * Rolls some of the dices.
     * @param s - String with the dices indexes to roll.
     * @return Returns the result of every dice in the array
     */
	public int[] roll(java.lang.String s) {
		int i, j, k;
		/* converts indexes in string to int */
		String aux[] = s.trim().split(" ");
		int indices[] = new int[aux.length];
		for (i = 0; i < aux.length; i++) {
			indices[i] = Integer.parseInt(String.valueOf(aux[i]));
		}
		/* rolls dices */
		int[] results = new int[dices.length];
		k = 0;
		j = indices[k] - 1;
		for (i = 0; i < dices.length; i++) {
			/* verifies if I'm supposed to roll this dice */
			if (i == j) {
				results[i] = dices[i].roll();
				k++;
                if (k < indices.length) {
                    j = indices[k] - 1;
                }
			} else {
				results[i] = dices[i].getResult();
			}	
		}
		return results;
	}

	/**
     	* Shows all dices horizontally in the screen
     	*/
	public void display() {

		int aux = 0, cont = 0;
		int i = 0, j=0, k=0;

		String[] d1 = new String[5];
		String[] d2 = new String[5];
		String[] d3 = new String[5];
		String[] d4 = new String[5];
		String[] d5 = new String[5];
		String[] d6 = new String[5];

		String[][] mat = new String[5][35];

		/* Dice 1 */
		d1[0] = "+-----+";
		d1[1] = "|     |";
		d1[2] = "|  *  |";
		d1[3] = "|     |";
		d1[4] = "+-----+";

		/* Dice 2 */
		d2[0] = "+-----+";
		d2[1] = "|    *|";
		d2[2] = "|     |";
		d2[3] = "|*    |";
		d2[4] = "+-----+";

		/* Dice 3 */
		d3[0] = "+-----+";
		d3[1] = "|    *|";
		d3[2] = "|  *  |";
		d3[3] = "|*    |";
		d3[4] = "+-----+";

		/* Dice 4 */
		d4[0] = "+-----+";
		d4[1] = "|*   *|";
		d4[2] = "|     |";
		d4[3] = "|*   *|";
		d4[4] = "+-----+";

		/* Dice 5 */
		d5[0] = "+-----+";
		d5[1] = "|*   *|";
		d5[2] = "|  *  |";
		d5[3] = "|*   *|";
		d5[4] = "+-----+";

		/* Dice 6 */
		d6[0] = "+-----+";
		d6[1] = "|*   *|";
		d6[2] = "|*   *|";
		d6[3] = "|*   *|";
		d6[4] = "+-----+";


		for(i = 0; i < 5; i++){
			aux = dices[i].getResult();

			switch(aux){
				case 1:
					/* j controls line flow */
					for(j = 0; j < 5; j++){
						/* k iterates the matrix */
						mat[j][k] = d1[j];
					}
					/* get the other dices */
					k++;
					break;
				case 2:
					for(j = 0; j < 5; j++){
						mat[j][k] = d2[j];
					}
					k++;
					break;
				case 3:
					for(j = 0; j < 5; j++){
						mat[j][k] = d3[j];
					}
					k++;
					break;
				case 4:
					for(j = 0; j < 5; j++){
						mat[j][k] = d4[j];
					}
					k++;
					break;
				case 5:
					for(j = 0; j < 5; j++){
						mat[j][k] = d5[j];
					}
					k++;
					break;
				case 6:
					for(j = 0; j < 5; j++){
						mat[j][k] = d6[j];
					}
					k++;
					break;
			}

		}

		/* print the matrix */
		for(i = 0; i < 5; i++){
			System.out.print(mat[i][0] +"\t"+ mat[i][1] +"\t"+ mat[i][2] +"\t"+ mat[i][3] +"\t"+ mat[i][4] +"\t\n");
		}
	}
}