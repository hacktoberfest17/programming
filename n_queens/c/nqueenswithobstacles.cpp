#include<iostream>
#include<vector>
#include<cstdio>
#include<queue>
#include<stack>
#include<cstring>
#include<cmath>
#include<ctime>
#include<cstdlib>

using namespace std;

#define toDigit(c)  (c-'0')

struct node {
    vector< vector<int> > board;
    long int rowcol;
    int p;
};

void printBoard(vector< vector<int> > board){
    int n = board.size();
 	printf("OK\n");
    for(int i=0;i<n;i++){
        for(int j=0; j<n; j++){
            printf("%d", board[i][j]);
        }
        printf("\n");
    }
}

bool isSafe(vector <vector<int> > board, int row, int col){
    int i, j, n = board.size();

    for (i = col-1; i >= 0; i--)   //left
        if (board[row][i] == 1)
            return false;
        else if(board[row][i] == 2)
            break;

    for (i = row-1; i >= 0; i--)    //up
        if (board[i][col] == 1)
            return false;
        else if(board[i][col] == 2)
            break;

    for (i=row, j=col; i>=0 && j>=0; i--, j--)  // up left
        if (board[i][j] == 1)
            return false;
        else if(board[i][j] == 2)
            break;

    for (i=row, j=col; j>=0 && i>=0; i--, j++)  // up right
        if (board[i][j] == 1)
            return false;
        else if(board[i][j] == 2)
            break;

    return true;
}

int findCost (vector<vector<int> > board, vector<long int> queens){

    int cost = 0, i, j, n = board.size(), p = queens.size(), row, col;
    long int rowcol;

    for(i=0; i<p;i++){
        rowcol = queens[i];
        row = rowcol/n;
        col = rowcol%n;

        for (i = col-1; i >= 0; i--)   //left
            if (board[row][i] == 1){
                cost++;
                break;
            }
            else if(board[row][i] == 2)
                break;

        for (i = row-1; i >= 0; i--)    //up
            if (board[i][col] == 1){
                cost++;
                break;
            }
            else if(board[i][col] == 2)
                break;

        for (i=row, j=col; i>=0 && j>=0; i--, j--)  // up left
            if (board[i][j] == 1){
                cost++;
                break;
            }
            else if(board[i][j] == 2)
                break;

        for (i=row, j=col; j>=0 && i>=0; i--, j++)  // up right
            if (board[i][j] == 1){
                cost++;
                break;
            }
            else if(board[i][j] == 2)
                break;
    }

    return cost;

}

bool solveDFS(vector <vector<int> > board, long int rowcol, int p){
    int n = board.size();
    int n2 = n*n;

    if (p == 0){
        printBoard(board);
        return true;
    }

    for(long int i = rowcol; i<n2; i++){

        int row = i/n;
        int col = i%n;

        if( board[row][col] != 2 && isSafe(board, row, col) ){
            board[row][col] = 1;

            if( solveDFS(board, i+1, p-1) )
                return true;
        }

        if( board[row][col] != 2)  board[row][col] = 0;
    }

    return false;
}

bool solveBFS(queue<node> container) {

//    printBoard(container.top().board);

    int n = container.front().board.size();
    long int n2 = n*n;
    int row, col, i;

    while(container.size()){

        node current = container.front();
        container.pop();

        if(current.p == 0) {
            printBoard(current.board);
            return true;
        }

        for(i = current.rowcol; i<n2; i++){

            row = i/n;
            col = i%n;
            if( current.board[row][col] != 2 && isSafe(current.board, row, col) ){

                current.board[row][col] = 1;
                current.rowcol = i+1;
                current.p -= 1;
                container.push(current);

                if(current.p == 0) {
                    printBoard(current.board);
                    return true;
                }

                //original
                current.board[row][col] = 0;
                current.rowcol = i;
                current.p += 1;

            }

        }

    }

    return false;

}

bool solveSA(vector<vector<int> > board, int p){
    int start_s=clock();
    int n = board.size();
    long int n2 = n*n, oldPlace, placeQueen;
    int p2 = p, i, j;
    int row, col, cost, newCost, pickQueen;
    vector<long int> queens;
    double T = 10000, c, coolingRate = 0.003, prob;

    // random init
    while(p2){
        placeQueen = rand()%n2;
        row = placeQueen/n;
        col = placeQueen%n;
        if(board[row][col] == 0){
            board[row][col] = 1;
            p2--;
            queens.push_back(placeQueen);
        }
    }

    newCost = findCost(board, queens);

    while(T > 1 && (((clock()-start_s)/double(CLOCKS_PER_SEC)*1000) < 280000)) {         //200000 milliseconds
        cost = newCost;
        pickQueen = rand() % p;
        oldPlace = queens[pickQueen];
        row = oldPlace/n;
        col = oldPlace%n;
        board[row][col] = 0;

        placeQueen = rand() % n2;
        row = placeQueen/n;
        col = placeQueen%n;
        if(board[row][col] != 0)
            continue;

        queens[pickQueen] = placeQueen;
        newCost = findCost(board, queens);
        if (newCost == 0){
            printBoard(board);
            return true;
        }

        if (newCost < cost)
            continue;

        c = exp(((double)cost-newCost)/T);
        p = (rand()%100)/100;
        if(c < p){

            board[row][col] = 0;
            queens[pickQueen] = oldPlace;
            row = oldPlace/n;
            col = oldPlace%n;
            board[row][col] = 1;
        }

        // cool system
        T *= 1-coolingRate;
    }

    return false;

}

int main(){

    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    node board;
    board.rowcol = 0;
    int n, i, j, p;
    char cip, mode[5];
    vector<int> row;
    queue<node> containerBFS;
    stack<node> containerDFS;

    scanf("%s", mode);
    scanf("%d %d ", &n, &p);
    board.p = p;
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            scanf("%c", &cip);
            row.push_back(toDigit(cip));
        }
        getchar();
        board.board.push_back(row);
        row.clear();
    }

    if(strcmp(mode, "DFS")){
        if(solveDFS(board.board, 0, p) == false)
            printf("FAIL\n");
    }

    else if(strcmp(mode, "BFS")){
        containerBFS.push(board);
        if(solveBFS(containerBFS) == false)
            printf("FAIL\n");
    }

    else {
        if(solveSA(board.board, p) == false)
            printf("Fail\n");
    }

    return 0;
}
