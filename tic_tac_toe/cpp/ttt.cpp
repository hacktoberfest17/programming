#include <iostream>
#include<string>
#include<cstdlib>

using namespace std;

int splashScreen();
int switchPlayer(int HUMAN);
int resetGame(char BOARD[]);
int displayGrid(char BOARD[]);
int validatePlayersMove(int choice);
int checkPositionAvailability(int choice, char BOARD[]);
int playerMakeMove(char BOARD[]);
int checkWin(char BOARD[]);
int checkTie(char BOARD[]);
int computerMakeMove(char BOARD[]);

int main()
{
    char BOARD[9] = { '0','1','2','3','4','5','6','7','8' };
    string userEntry;
    int HUMAN = 1;
    char playAgain = 'y';
    
    splashScreen();
    system("CLS");
    while (1)
    {
        if (HUMAN == 1)
        {
            playerMakeMove(BOARD);
        }
        else
        {
            computerMakeMove(BOARD);
        }
        if (checkWin(BOARD))
        {
            if (HUMAN == 1)
            {
                cout << "Human win!" << endl;
            }
            else
            {
                cout << "Computer win!" << endl;
            }
            cout << "GAME OVER! Press Y/y to play again, any other to exit." << endl;
            cin >> playAgain;
            if (playAgain == 'y' || playAgain == 'Y')
            {
                resetGame(BOARD);
            }
            else
            {
                cout << "Bye-bye!" << endl;
                return 0;
            }
            
        }
        else if (checkTie(BOARD))
        {
            cout << "It's a tie!" << endl;
            cout << "GAME OVER! Press Y/y to play again, any other to exit." << endl;
            cin >> playAgain;
            if (playAgain == 'y' || playAgain == 'Y')
            {
                resetGame(BOARD);
            }
            else
            {
                cout << "Bye-bye!" << endl;
                return 0;
            }
            
        }
        HUMAN = switchPlayer(HUMAN);
        
    }

    system("pause");
    return 0;
}
int splashScreen()
{
    string userEntry;
    cout << "*********       FINAL      *********" << endl;
    cout << "************************************" << endl;
    cout << "************************************" << endl;
    cout << "*********                  *********" << endl;
    cout << "*********    TIC TAC TOE   *********" << endl;
    cout << "*********        BY:       *********" << endl;
    cout << "*********       ERNIE      *********" << endl;
    cout << "*********                  *********" << endl;
    cout << "************************************" << endl;
    cout << "************************************" << endl;
    cout << "\nPress any KEY to continue then <ENTER>......" << endl;
    getline(cin, userEntry);
    return 0;
}
int switchPlayer(int HUMAN)
{
    HUMAN++;
    return HUMAN % 2;
}
int resetGame(char BOARD[])
{
    for (int i = 0; i < 9; i++)
    {
        BOARD[i] = (char)(i + 48);
    }
    return 0;
}
int displayGrid(char BOARD[])
{
    
    cout << "Tic Tac Toe" << endl;
    cout << "\n+-+-+-+" << endl;
    cout << "|" << BOARD[0] << "|" << BOARD[1] << "|" << BOARD[2] << "|" << endl;
    cout << "+-+-+-+" << endl;
    cout << "|" << BOARD[3] << "|" << BOARD[4] << "|" << BOARD[5] << "|" << endl;
    cout << "+-+-+-+" << endl;
    cout << "|" << BOARD[6] << "|" << BOARD[7] << "|" << BOARD[8] << "|\n";
    cout << "+-+-+-+" << endl;
    
    return 0;
    
}
int validatePlayersMove(int choice)
{
    
    if (choice >= 0 && choice <= 8)
    {
        return 1;
    }
    return 0;
}
int checkPositionAvailability(int choice, char BOARD[])
{
    
    if (BOARD[choice] != 'C'&&BOARD[choice] != 'H')
    {
        return 1;
    }
    return 0;
}

int playerMakeMove(char BOARD[])
{
    int choice;
    while (1)
    {
        displayGrid(BOARD);
        cout << "It is the human's turn" << endl;
        cout << "Give me your best move!" << endl;
        cin >> choice;
        if (validatePlayersMove(choice))
        {
            if (checkPositionAvailability(choice, BOARD))
            {
                char mark;
                
                mark = 'H';
                
                if (choice == 0 && BOARD[0] == '0')
                {
                    BOARD[0] = mark;
                }
                else if (choice == 1 && BOARD[1] == '1')
                {
                    BOARD[1] = mark;
                }
                else if (choice == 2 && BOARD[2] == '2')
                {
                    BOARD[2] = mark;
                }
                else if (choice == 3 && BOARD[3] == '3')
                {
                    BOARD[3] = mark;
                }
                else if (choice == 4 && BOARD[4] == '4')
                {
                    BOARD[4] = mark;
                }
                else if (choice == 5 && BOARD[5] == '5')
                {
                    BOARD[5] = mark;
                }
                
                else if (choice == 6 && BOARD[6] == '6')
                {
                    BOARD[6] = mark;
                }
                else if (choice == 7 && BOARD[7] == '7')
                {
                    BOARD[7] = mark;
                }
                else if (choice == 8 && BOARD[8] == '8')
                {
                    BOARD[8] = mark;
                }
                
                return 0;
                
            }
            else
            {
                cout << "Position not available" << endl;
                cout << "make a different choice" << endl;
                cin.clear();
                cin.ignore(10000, '\n');
            }
        }
        else
        {
            cout << "Position not available" << endl;
            cout << "make a different choice" << endl;
            cin.clear();
            cin.ignore(10000, '\n');
        }
        
    }
    return 0;
    
}

int checkWin(char BOARD[])
{
    if (BOARD[0] == BOARD[1] && BOARD[1] == BOARD[2])
    {
        return 1;
    }
    else if (BOARD[3] == BOARD[4] && BOARD[4] == BOARD[5])
    {
        return 1;
    }
    else if (BOARD[6] == BOARD[7] && BOARD[7] == BOARD[8])
    {
        return 1;
    }
    else if (BOARD[0] == BOARD[3] && BOARD[3] == BOARD[6])
    {
        return 1;
    }
    else if (BOARD[1] == BOARD[4] && BOARD[4] == BOARD[7])
    {
        return 1;
    }
    else if (BOARD[2] == BOARD[5] && BOARD[5] == BOARD[8])
    {
        return 1;
    }
    else if (BOARD[0] == BOARD[4] && BOARD[4] == BOARD[8])
    {
        return 1;
    }
    else if (BOARD[2] == BOARD[4] && BOARD[4] == BOARD[6])
    {
        return 1;
    }
    else
    {
        return 0;
    }
}
int checkTie(char BOARD[])
{
    if (BOARD[1] != '1' && BOARD[2] != '2' && BOARD[3] != '3'
        && BOARD[4] != '4' && BOARD[5] != '5' && BOARD[6] != '6'
        && BOARD[7] != '7' && BOARD[8] != '8' && BOARD[0] != '0')
        
        return 1;
    return 0;
}
int computerMakeMove(char BOARD[])
{
    int choice;
    
    do
    {
        choice = rand() % 9;
        
        if (BOARD[choice] != 'H'&& BOARD[choice] != 'C')
        {
            char mark = 'C';
            
            if (choice == 0 && BOARD[0] == '0')
            {
                BOARD[0] = mark;
            }
            else if (choice == 1 && BOARD[1] == '1')
            {
                BOARD[1] = mark;
            }
            else if (choice == 2 && BOARD[2] == '2')
            {
                BOARD[2] = mark;
            }
            else if (choice == 3 && BOARD[3] == '3')
            {
                BOARD[3] = mark;
            }
            else if (choice == 4 && BOARD[4] == '4')
            {
                BOARD[4] = mark;
            }
            else if (choice == 5 && BOARD[5] == '5')
            {
                BOARD[5] = mark;
            }
            else if (choice == 6 && BOARD[6] == '6')
            {
                BOARD[6] = mark;
            }
            else if (choice == 7 && BOARD[7] == '7')
            {
                BOARD[7] = mark;
            }
            else if (choice == 8 && BOARD[8] == '8')
            {
                BOARD[8] = mark;
            }
            return 0;
            
        }
        
    } while (1);
    
    return 0;
}
