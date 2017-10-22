/**
 * User interaction - Yahtzee game
 * @author Felipe Custodio, Gabriel Scalici
 */

public class Yahtzee {
	
    public Yahtzee() {

    }

    public static void main(java.lang.String[] args) throws java.io.IOException {
        String toRoll;
        int position;
        int[] results = new int[5];
        int playCounter;
        int userInput;
        int usedPosition;
        int finalScore = 0;
        RollDice dice = new RollDice(5);
        Score score = new Score();
        /* 10 rounds */
        for (int i = 0; i < 10; i++) {
            System.out.println("ROUND " + i+1);
            System.out.print("Press ENTER to start! ");
            Input.readString();
            playCounter = 0;
            System.out.println("Rolling dices...");
            results = dice.roll();
            System.out.println("Your results:");
            /* show dices */
            dice.display();
            /* player has three attmepts to roll the dices */
            while (playCounter < 3) {
                System.out.println("Roll again or insert results in scoreboard?");
                System.out.println("1) Roll 2) Insert in scoreboard");
                userInput = Input.readInt();
                if (userInput == 1) {
                    System.out.print("Pick the dices to be rolled again (separated by space) ");
                    toRoll = Input.readString();
                    results = dice.roll(toRoll);
                    System.out.println("Your results:");
                    /* show dices */
                    dice.display();
                    playCounter++;
                } else {
                    if (userInput == 2) {
                        playCounter = 3;
                    }
                }
            }
            /* add score to scoreboard */
            usedPosition = 0;
            position = 0;
            while (usedPosition != 1) {
                System.out.println("Pick the position to insert");
                System.out.println("1 2 3 4 5 6 7 8 9 10");
                position = Input.readInt();
                switch (position) {
                    case 1:
                        position = 0;
                        break;
                    case 2:
                        position = 3;
                        break;
                    case 3:
                        position = 6;
                        break;
                    case 4:
                        position = 2;
                        break;
                    case 5:
                        position = 5;
                        break;
                    case 6:
                        position = 8;
                        break;
                    case 7:
                        position = 1;
                        break;
                    case 8:
                        position = 4;
                        break;
                    case 9:
                        position = 7;
                        break;
                    case 10:
                        position = 10;
                        break;
                }
                if (score.plays[position] == -1) {
                    score.add(position, results);
                    score.display();
                    usedPosition = 1;
                } else {
                    System.out.println("You already used this position! Choose another.");
                    usedPosition = 0;
                }
            }
        }
        /* game over */
        finalScore = score.getScore();
        System.out.println("GAME OVER!");
        score.display();
        System.out.print("Final score: " + finalScore);
	}
}