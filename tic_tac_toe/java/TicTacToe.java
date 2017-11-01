
public class TicTacToe {

	public boolean hasWinner(char[][] b, char player) {
		// TODO Auto-generated method stub
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				boolean check = true;
				if (b[i][j] == player) {
					for (int row = 0; row < b.length; row++) {
						if (b[i][row] != player) {

							check = false;
						}
					}
					if (check == true) {
						return check;
					}
					check = true;
					for (int column = 0; column < b.length; column++) {

						if (b[column][j] != player) {
							check = false;
						}
					}
					if (check == true) {
						return check;
					}

					if (i == j) {
						check = true;
						for (int dia = 0; dia < b.length; dia++) {
							if (b[dia][dia] != player) {
								check = false;
							}
						}
						if (check == true) {
							return check;
						}
					}
					if ((i == 1 && j == 1) || (i == 2 && j == 0) || (i == 0 && j == 2)) {
						check = true;
						for (int dia = 0; dia < b.length; dia++) {
							if (board[dia][2 - dia] != player) {
								check = false;
							}
						}

						if (check == true) {
							return check;
						}
					}

				}

			}
		}
		return false;
	}

	public void printBoard(char[][] board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println("");
		}

	}

	public void intializeBoard(char[][] board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = '0';
			}
		}

	}

	public boolean validMove(char[][] board, int[] playerMove, char player) {
		// TODO Auto-generated method stub
		if (board[playerMove[0]][playerMove[1]] == '0') {
			return true;
		}
		return false;
	}

	public char changePlayer(char player) {
		// TODO Auto-generated method stub
		if (player == 'X') {
			player = 'O';
		} else {
			player = 'X';
		}
		return player;
	}

  public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe game = new TicTacToe();
		char[][] board = new char[3][3];
		int moves = 9;
		game.intializeBoard(board);
		char player;
		System.out.println("Welcome to XO game");
		System.out.println("the first player is X");
		player = 'X';
		Scanner scan = new Scanner(System.in);
		while (moves != 0) {
			System.out.println("enter the coordinates of your move");
			int x = scan.nextInt();
			int y = scan.nextInt();
			if (x < 0 || x > board.length - 1 || y < 0 || y > board.length - 1) {
				System.out.println("invalid Move");
				continue;
			}
			int[] playerMove = new int[2];
			playerMove[0] = x;
			playerMove[1] = y;
			if (game.validMove(board, playerMove, player)) {
				board[x][y] = player;
				moves--;
				if (game.hasWinner(board, player)) {
					game.printBoard(board);
					System.out.printf("Congratulations player %c has Won", player);
					break;
				} else {
					player = game.changePlayer(player);
				}
			} else {
				System.out.println("invalid Move");
				continue;

			}
			game.printBoard(board);
		}
		if (moves == 0) {
			System.out.println("No one won");
		}
		scan.close();

	}
}
