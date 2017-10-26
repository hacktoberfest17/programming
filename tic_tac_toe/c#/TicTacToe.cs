using System;

namespace tic_tac_toe
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            char[,] board = new char[3,3];
            int movesRemaining = 9;
            char player = 'X';
            int row = 0, col = 0;
            char winner = '\0';

            InitializeBoard(board);

            while(movesRemaining > 0)
            {
                bool validMove = false;

                Console.WriteLine("Current Player: " + player);

                while (!validMove)
                {
                    Console.Write("Enter row (1, 2, or 3): ");
                    row = int.Parse(Console.ReadLine()) - 1;
                    Console.Write("Enter column (1, 2, or 3): ");
                    col = int.Parse(Console.ReadLine()) - 1;

                    validMove = (row >= 0) && (row < 3) && (col >= 0) &&
                        (col < 3) && board[row,col] == ' ';
                    
                    if (!validMove)
                        Console.WriteLine("Invalid Move. Try again.");
                }

                board[row, col] = player;

                PrintBoard(board);

                winner = CheckForWinner(board);
                if (winner != '\0')
                {
                    Console.WriteLine("Player " + winner + " wins!");
                    break;
                }

                player = (player == 'X') ? 'O' : 'X';

                movesRemaining--;
            }

            if (movesRemaining == 0)
            {
                winner = CheckForWinner(board);
                if (winner != '\0') 
                    Console.WriteLine("Player " + winner + " wins!");
                else
                    Console.WriteLine("Tie.");
            }
        }

        private static void InitializeBoard(char[,] board)
        {
            // populate a new board with spaces
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    board[i, j] = ' ';
                }
            }
        }

        private static void PrintBoard(char[,] board)
        {
            for (int i = 0; i < 3; i++)
            {
                Console.WriteLine(board[i,0] + " | " + board[i,1] +
                                 " | " + board[i,2]);
                if (i < 2) Console.WriteLine("---------");
            }
            Console.WriteLine();
        }

        private static char CheckForWinner(char[,] board)
        {
            // loop through the rows
            for (int i = 0; i < 3; i++) {
                if (board[i, 0] != ' ' && board[i, 0] == board[i, 1] &&
                    board[i, 0] == board[i, 2])
                    return board[i, 0];
            }

            // loop through the columns
            for (int i = 0; i < 3; i++)
            {
                if (board[0, i] != ' ' && board[0, i] == board[1, i] &&
                    board[0,i] == board[2,i])
                    return board[0, i];
            }

            // check the 2 diagonals
            if (board[0, 0] != ' ' && board[0, 0] == board[1, 1] &&
                board[0, 0] == board[2, 2])
                return board[0, 0];
            if (board[0, 2] != ' ' && board[0, 2] == board[1, 1] &&
                board[0, 2] == board[2, 0])
                return board[0, 2];

            return '\0';
        }
    }
}
