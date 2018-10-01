package cc;

public class stoneGame {

	public static int winner(int stones, int player) {
		if (stones < 2) {
			if (player == 1) {
				return 2;
			} else
				return 1;
		}
		int win = 0;
		win = winner(stones - 2, player);
		if (win == player) {
			return win;
		}
		win = winner(stones - 2, player);
		if (win == player) {
			return win;
		}
		win = winner(stones - 2, player);
		if (win == player) {
			return win;
		}
	}

	public static void main(String[] args) {

	}

}
