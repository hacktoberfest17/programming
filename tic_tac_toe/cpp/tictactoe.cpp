/* A Basic Tic Tac Toe Game implemented in C++ by Jap Leen Kaur Jolly */

 
#include<bits/stdc++.h>
using namespace std;
 
int COMPUTER= 1;
int HUMAN=2;
 
#define LENGTH 3
 
// Computer will move with 'X'and human with '0'
#define COMPUTERMOVE 'X'
#define HUMANMOVE '0'
 

void Board(char board[][LENGTH])
{
    printf("\n\n");
     
    printf("\t\t\t  %c | %c  | %c  \n", board[0][0], board[0][1], board[0][2]);
    printf("\t\t\t--------------\n");
    printf("\t\t\t  %c | %c  | %c  \n", board[1][0], board[1][1], board[1][2]);
    printf("\t\t\t--------------\n");
    printf("\t\t\t  %c | %c  | %c  \n\n", board[2][0], board[2][1], board[2][2]);
  
  
}
 

void Instructions()
{
    printf("\t\t\t  Tic-Tac-Toe\n\n");
    printf("To start the game, choose a box numbered from 1 to 9 as below \n\n");
     
    printf("\t\t\t  1 | 2  | 3  \n");
    printf("\t\t\t--------------\n");
    printf("\t\t\t  4 | 5  | 6  \n");
    printf("\t\t\t--------------\n");
    printf("\t\t\t  7 | 8  | 9  \n\n");
     
    printf("-\t-\t-\t-\t-\t-\t-\t-\t-\t-\n\n");
 
  
}
 
 
void initialise(char board[][LENGTH],int moves[])
{
    // Initiating the random number generator 
    srand(time(NULL)); 
     
    // Initially the board is empty
    for (int i=0; i<LENGTH; i++)
    {
        for (int j=0; j<LENGTH; j++)
            board[i][j] = ' ';
    }
     
    // Filling the moves with numbers
    for (int i=0; i<LENGTH*LENGTH; i++)
        moves[i] = i;
 
    random_shuffle(moves, moves + LENGTH*LENGTH);
     
}
 

void winner(int Turn)
{
    if (Turn == COMPUTER)
        printf("HUMAN has won\n");
    else
        printf("COMPUTER has won\n");
    
}
 

bool row(char board[][LENGTH])
{
    for (int i=0; i<LENGTH; i++)
    {
        if (board[i][0] == board[i][1] &&
            board[i][1] == board[i][2] && 
            board[i][0] != ' ')
            return (true);
    }
    return(false);
}
 

bool column(char board[][LENGTH])
{
    for (int i=0; i<LENGTH; i++)
    {
        if (board[0][i] == board[1][i] &&
            board[1][i] == board[2][i] && 
            board[0][i] != ' ')
            return (true);
    }
    return(false);
}
 
bool diagonal(char board[][LENGTH])
{
    if (board[0][0] == board[1][1] &&
        board[1][1] == board[2][2] && 
        board[0][0] != ' ')
        return(true);
         
    if (board[0][2] == board[1][1] &&
        board[1][1] == board[2][0] &&
         board[0][2] != ' ')
        return(true);
 
    return(false);
}
 
bool gameOver(char board[][LENGTH])
{
    return(row(board) || column(board)
            || diagonal(board) );
}//Returns true if the game is over
 

void TicTacToe(int Turn)
{
    // A 3*3 Tic-Tac-Toe board for playing 
    char board[LENGTH][LENGTH];
     
    int moves[LENGTH*LENGTH];
     
    
    initialise(board, moves);
    Instructions();
     
    int flag = 0, x, y;
     
    // Playing till the game is over or it is a draw
    while (gameOver(board) == false && 
            flag != LENGTH*LENGTH)
    {
        if (Turn == COMPUTER)
        {
            x = moves[flag] / LENGTH;
            y = moves[flag] % LENGTH;
            board[x][y] = COMPUTERMOVE;
            printf("COMPUTER has put a %c in box %d\n",
                    COMPUTERMOVE, moves[flag]+1);
            Board(board);
            flag ++;
            Turn = HUMAN;
        }
         
        else if (Turn == HUMAN)
        {
            x = moves[flag] / LENGTH;
            y = moves[flag] % LENGTH;
            board[x][y] = HUMANMOVE;
            printf ("HUMAN has put a %c in box %d\n",
                    HUMANMOVE, moves[flag]+1);
            Board(board);
            flag ++;
            Turn = COMPUTER;
        }
    }
 
    if (gameOver(board) == false && 
            flag == LENGTH * LENGTH)
        printf("It's a draw\n");
    else
    {
        winner(Turn);
    }
 
}
 

int main()
{
    
   TicTacToe(COMPUTER);//COMPUTER starting first
     
    return 0;
}