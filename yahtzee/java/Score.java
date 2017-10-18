/**
 * Score board of the yahtzee game. Keeps track of player points.
 * @author Felipe Scrochio Custodio, Gabriel Scalici
 */
public class Score {
    /* positions = board with position numbers */
    private int[] positions;
    /* plays = board with scoring. -1 indicates position wasn't used yet. */
    public int[] plays;
    /* player total points */
    private int points;

    public Score() {
        /* fill scoreboard with positions and
        *  set plays positions to unused (-1) */
        positions = new int[11];
        plays = new int[11];
        for (int i = 0; i < 11; i++) {
            plays[i] = -1;
            switch (i) {
                case 0:
                    positions[0] = 1;
                    break;
                case 1:
                    positions[1] = 7;
                    break;
                case 2:
                    positions[2] = 4;
                    break;
                case 3:
                    positions[3] = 2;
                    break;
                case 4:
                    positions[4] = 8;
                    break;
                case 5:
                    positions[5] = 5;
                    break;
                case 6:
                    positions[6] = 3;
                    break;
                case 7:
                    positions[7] = 9;
                    break;
                case 8:
                    positions[8] = 6;
                    break;
                case 9:
                    positions[9] = -1;
                    break;
                case 10:
                    positions[10] = 10;
                    break;
            }
        }
        points = 0;
    }

    /* scoring methods */ 
    /**
     * checks if player has five dices of a kind
     * @param  dices results of the dices
     * @return  boolean
     */
    public boolean checkFive(int[] dices) {
        /* check for five of a kind */
        boolean isFive = false;
        int counter;
        for (int i = 0; i < dices.length; i++) {
            counter = 0;
            for (int j = 0; j < dices.length; j++) {
                if (dices[j] == dices[i]) {
                    counter++;
                }
            }
            if (counter == dices.length) {
                isFive = true;
            }
        }
        return isFive;
    }

    /**
     * checks if player has four dices of a kind
     * @param  dices results of the dices
     * @return  boolean
     */
    public boolean checkFour(int[] dices) {
        /* check for four of a kind */
        boolean isFour = false;
        int counter;
        for (int i = 0; i < dices.length; i++) {
            counter = 0;
            for (int j = 0; j < dices.length; j++) {
                if (dices[j] == dices[i]) {
                    counter++;
                }
            }
            if (counter == 4) {
                isFour = true;
            }
        }
        return isFour;
    }

    /**
     * checks for fullhouse scoring
     * @param  dices results of the dices
     * @return  boolean
     */
    public boolean fullHouse(int[] dices) {
        /* check for full house */
        int counter;
        boolean isFull = false;
        for (int i = 0; i < dices.length; i++) {
            counter = 0;
            for (int j = 0; j < dices.length; j++) {
                if (dices[j] == dices[i]) {
                    counter++;
                }
            }
            if (counter == 3) {
                isFull = true;
            }
        }
        return isFull;
    }

    /**
     * checks for straight scoring
     * @param  dices results of the dices
     * @return  boolean
     */
    public boolean checkStraight(int[] dices) {
        /* sort dices (bubble) */
        int aux;
        boolean isSeq = false;
        for (int i = 0; i < dices.length; i++) {
           for (int j = 0; j < 4; j++) {
            if (dices[j] > dices[j + 1]) {
                aux = dices[j];
                dices[j] = dices[j + 1];
                dices[j + 1] = aux;
            }
        }
    }
    aux = 0;
    /* check if sequence is 1 2 3 4 5 */
    for (int i = 0; i < dices.length; i++) {
        if (dices[i] == i + 1) {
            aux++;
        }
    }
    if (aux == 5) {
        isSeq = true;
    } else {
        /* check if sequence is 2 3 4 5 6 */
        aux = 0;
        for (int i = 0; i < dices.length; i++) {
            if (dices[i] == i + 2) {
                aux++;
            }
        }
        if (aux == 5) {
            isSeq = true;
        }
    }
    return isSeq;
}

    /**
     * Adds a score to a determined position in the scoreboard. Sets position to used.
     * @param Position to be filled, dices results
     */
    public void add(int position, int[] dices) throws java.lang.IllegalArgumentException {
        /* indexes of scoreboard != positions of scoreboard */
        int sum = 0;
        /* get sum of dices results */
        for (int i = 0; i < 5; i++) {
            sum += dices[i];
        }

        switch (position) {
            case 0:
                plays[0] = sum;
                break;
            case 1:
                /* check for full house */
                if (fullHouse(dices)) {
                    plays[1] = 15;
                } else {
                    plays[1] = 0;
                }
            case 2:
                plays[2] = sum;
                break;
            case 3:
                plays[3] = sum;
                break;
            case 4:
                /* check for straight sequence */
                if (checkStraight(dices)) {
                    plays[4] = 20;
                } else {
                    plays[4] = 0;
                }
            case 5:
                plays[5] = sum;
                break;
            case 6:
                plays[6] = sum;
                break;
            case 7:
                /* check for 4 of a kind */
                if (checkFour(dices)) {
                    plays[7] = 30;
                    break;
                } else {
                    plays[7] = 0;
                    break;
                }
            case 8:
                plays[8] = sum;
                break;
            case 10:
                /* check for five of a kind */
                if (checkFive(dices)) {
                    plays[10] = 40;
                } else {
                    plays[10] = 0;
                }
        }
    }

    /**
     * Gets the sum of results, considering only occupied positions
     * @return Retorna o valor da sum
     */
    public int getScore() {
        points = 0;
        for (int i = 0; i < 11; i++) {
            if (plays[i] != -1) points += plays[i];
        }
        return points;
    }

    /**
     * Graphic representation of the scoreboard
     */
    public void display() {
       
       int pos = 0;
       int breakLine = 0;

       for (int i = 0; i < 11; i++) {
            if (i != 9) {
                if (plays[i] != -1) {
                    System.out.print(plays[i] + "\t|\t");
                    breakLine++;
                } else {
                    System.out.print(positions[i] + "\t|\t");
                    breakLine++;
                }
                if (breakLine == 3) {
                    breakLine = 0;
                    System.out.print("\n");
                    System.out.println("---------------------");
                }
            } else {
                System.out.print("\t|\t");
            }
        }
        System.out.print("\n");
    }

}