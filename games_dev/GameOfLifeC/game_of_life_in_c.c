//*******************************************************************************************
//LANGUAGE: C
//ENV: Dev C++
//AUTHOR: Jeremy Ferguson
//GITHUB: https://github.com/wasabullfrog
//*******************************************************************************************

//Library inclusions
#include <stdio.h>
#include "simpio.h"
#include "strlib.h"

//Function prototypes for functions run in main.
void displayIntro(void);
void runGame(void);


//Function prototypes for functions run in the main game function

int getDimensions(void);
unsigned long int GetStages(void);
void initBoard(int dim,bool board[dim+2][dim+2]);
void displayBoard(int dim,bool board[dim+2][dim+2]);
void runStages(unsigned long int stages,int dim,bool board[dim+2][dim+2]);
void promptAgain(void);

//Functions prototypes related to the custom board path
void GetCustomBoard(int dim,bool board[dim+2][dim+2]);
void GetCustomRow(int dim,int row,bool board[dim+2][dim+2]);

//Functions prototypes related to the premade board path

//Parent of the premade board path
void GetPremadeBoard(int dim,bool board[dim+2][dim+2]);

//Functions that get and display boards that can be chosen as the starting board
void MakeX_Board(int dim,bool x_board[dim+2][dim+2]);
void makePentBoard(int dim,bool pent_board[dim+2][dim+2]);
void makeAcorn(int dim,bool acorn[dim+2][dim+2]);
void makeRPent(int dim,bool board[dim+2][dim+2]);
void makePulsar(int dim,bool board[dim+2][dim+2]);
void makeDieHard(int dim,bool board[dim+2][dim+2]);
void makePulsarRow(int dim,bool board[dim+2][dim+2],int startRow,int startColum);
void makePulsarColumn(int dim,bool board[dim+2][dim+2],int startRow,int startColumn);
void makeMathematician(int dim,bool board[dim+2][dim+2]);
void makeQueenBeeShuttle(int dim,bool board[dim+2][dim+2]);

//Function that relates the premade boards to the master board
void copyBoard(int dim,bool source[dim+2][dim+2],bool destination[dim+2][dim+2]);

//Functions related to the game board manipulation and iterations of the game
void fillDefault(int dim,bool board[dim+2][dim+2]);
void fillNeighborBoard(int dim,int neighbor_board[dim][dim],bool board[dim+2][dim+2]);
void runStage(int dim,bool board[dim+2][dim+2]);
int getNeighbors(int dim,int x,int y,bool board[dim+2][dim+2]);
unsigned long int GetLivingCells(int dim,bool board[dim+2][dim+2]);

main(){
	displayIntro();
	runGame();
}

//Functions run from main function

//*******************************************************************************************
//NAME: displayIntro
//PURPOSE: To display an introductory message to the user.  
//PASSED: void
//RETURNED: void
//*******************************************************************************************

void displayIntro(void){
	printf("Welcome to the Game of Life.  This is a cellular automaton \nin which a set of initial patterns\n");
	printf("determines the total outcome of the simulation.  \nThe board consists of cells of either living or dead creatures,\n");
	printf("which behave according to a few simple rules.  \nIf a creature has more than 3 neighbors, it dies of crowding.\n");
	printf("If a creature has less than 2 neighbors, it dies of loneliness.  \nAnd if an empty cell has exactly 3 neighbors,\n");
	printf("a new creature is born by reproduction.  \nIn this simulation, the size of the board must be at least 10x10, and \nthe board will always be a square.\n");
	printf("For questions, comments, or to see source code, please contact Jeremy Ferguson.\n");
}

//*******************************************************************************************
//NAME: runGame
//PURPOSE: To begin running the game loop
//PASSED: void
//RETURNED: void
//*******************************************************************************************

void runGame(void){
	/*Get the dimensions of the game board from the user and declare an array using the
	dimension input.  The array is of 2 sizes larger than the dimensions so that the
	borders can be declared to false as to not interfere with the game.*/
	int dim = getDimensions();
	bool board[dim+2][dim+2];
	//Initialize the board so that it has the desired setup to run the simulation
	initBoard(dim,board);
	printf("Initial board:\n");
	displayBoard(dim,board);
	//Get the number of stages the user wants to run the simulation for, and 
	//begin running the simulation.
	unsigned long int stages = GetStages();
	runStages(stages,dim,board);
	//Ask the user if he/she wants to play the game again.
	promptAgain();
}

//Functions run from the main game function

//*******************************************************************************************
//NAME: promptAgain
//PURPOSE: To ask the user if he/she wants to play the game again, and if so, to run the game again.
//PASSED: void
//RETURNED: void
//*******************************************************************************************

void promptAgain(void){
	printf("Play again? ");
	//Get the user input and check whether they answered yes or no.  If yes, run the program again.
	//If no, exit the program.  Otherwise, run this function again.
	string answer = GetLine();
	if(StringEqual(answer,"yes")){
		runGame();
	}
	else if(StringEqual(answer,"no")){
		printf("Exiting program.\n");
	}
	else{
		printf("Invalid answer. Please enter yes or no.\n");
		promptAgain();
	}
}

//*******************************************************************************************
//NAME: getDimensions
//PURPOSE: To get the size of the board as input from the user.
//PASSED: void
//RETURNED: int dim: integer that represents the size of the board.
//*******************************************************************************************

int getDimensions(void){
	printf("Enter size of board: \n");
	int dim = GetInteger();
	if(dim >=10){
		return dim;
	}
	else{
		printf("Invalid dimensions.  Try again using dimensions of at least 10 x 10.\n");
		return getDimensions();
	}
}

//*******************************************************************************************
//NAME: initBoard
//PURPOSE: To initialize the board based on whether or not the user wants a custom or premade board.
//PASSED: int dim: size of the board
//PASSED: bool board[dim+2][dim+2]: array that represents the game board.
//RETURNED: void
//*******************************************************************************************

void initBoard(int dim,bool board[dim+2][dim+2]){
	printf("Type in \"custom\" to create your own custom board or \"premade\" to choose from a set of premade boards: ");
	string choice = GetLine();
	fillDefault(dim,board);
	if(StringEqual(choice,"custom")){
		GetCustomBoard(dim,board);
	}
	else if(StringEqual(choice,"premade")){
		GetPremadeBoard(dim,board);
	}
	else{
		printf("Invalid answer.  Please try again  using either \"custom\" or \"premade\"\n");
		initBoard(dim,board);
	}
}

//*******************************************************************************************
//NAME: displayBoard
//PURPOSE: To display a board to the output
//PASSED: int dim: size of the board
//PASSED: bool board[dim+2][dim+2]: array that represents the game board.
//RETURNED: void
//*******************************************************************************************

void displayBoard(int dim,bool board[dim+2][dim+2]){
	int i,j;
	for(i=1;i<dim+1;i++){
		for(j=1;j<dim+1;j++){
			if(board[i][j]){
				printf("*");
			}
			else{
				printf("-");
			}
		}
		printf("\n");
	}
}

//*******************************************************************************************
//NAME: GetStages
//PURPOSE: To get the number of stages to run the simulation for
//PASSED: void
//RETURNED: unsigned long int stages: number of stages to run the simulation for
//*******************************************************************************************

unsigned long int GetStages(void){
	printf("Enter the number of stages you want the game to run for: ");
	unsigned long int stages = GetLong();
}

//*******************************************************************************************
//NAME: runStages
//PURPOSE: To run the simulation in a set number of stages with an initial board
//PASSED: unsigned long int stages: number of stages to run the simulation for
//PASSED: int dim: size of the board
//PASSED: bool board[dim+2][dim+2]: array that represents the game board.
//RETURNED: void
//*******************************************************************************************

void runStages(unsigned long int stages, int dim,bool board[dim+2][dim+2]){
	unsigned long int i,j;
	for(i=1;i<=stages;i++){
		//for each iteration until it has reached its stage limit, the function runs a stage
		//displays the new board, and executes a large for loop to delay the program so the
		//user can read the board
		runStage(dim,board);
		displayBoard(dim,board);
		printf("Iteration %d:\n",i);
		printf("Current living cells: %d\n",GetLivingCells(dim,board));
		for(j=0;j<500000000;j++);
	}
}

//Functions related to the custom board path

//*******************************************************************************************
//NAME: GetCustomBoard
//PURPOSE: To build a custom board using input from the user.
//PASSED: int dim: size of the board
//PASSED: bool board[dim+2][dim+2]: array that represents the board.
//RETURNED: void
//*******************************************************************************************

void GetCustomBoard(int dim,bool board[dim+2][dim+2]){
	int i;
	printf("To enter a row of the custom board, use \"*\" for a live cell and \"-\" for a dead cell\n");
	for(i=1;i<dim+1;i++){
		//For each iteration of the board, the number of rows in the board, it gets the next 
		//row of the custom board using the GetCustomRow function
		printf("Enter row #%d of custom board:\n",i);
		GetCustomRow(dim,i,board);
	}
	
}

//*******************************************************************************************
//NAME: GetCustomRow
//PURPOSE: To get a row of the custom board using input from the user and assign it to the array
//PASSED: int dim: size of the board
//PASSED: bool board[dim+2][dim+2]: array that represents the board.
//RETURNED: void
//*******************************************************************************************

void GetCustomRow(int dim,int row,bool board[dim+2][dim+2]){
	int i;
	char ch;
	for(i=1;i<dim+1;i++){
		//For each element in the row, the function gets input from the user and assigns the
		//appropriate value in the array either true or false depending on the character
		ch = getchar();
		if(ch == '-'){
			board[row][i]=false;
		}
		if(ch == '*'){
			board[row][i]=true;
		}
		
	}
	ch = getchar();
}

//Functions related to the premade board path.

//*******************************************************************************************
//NAME: GetPremadeBoard
//PURPOSE: To make the master board according to one of the premade boards.
//PASSED: int dim: size of the board
//PASSED: bool board[dim+2][dim+2]: array that represents the board.
//RETURNED: void
//*******************************************************************************************

void GetPremadeBoard(int dim,bool board[dim+2][dim+2]){
	//Display a welcome message and initialize all of the premade boards
	printf("Welcome to premade choice selection!\n");
	bool x_board[dim+2][dim+2];
	bool pent_board[dim+2][dim+2];
	bool acorn[dim+2][dim+2];
	bool mathematician[dim+2][dim+2];
	bool pulsar[dim+2][dim+2];
	bool rPent[dim+2][dim+2];
	bool diehard[dim+2][dim+2];
	bool queenBeeShuttle[dim+2][dim+2];
	//Display the choices for the smallest board size: 10x10
	//Each premade board is one of two categories: oscillators, which repeat every few iterations,
	//or methuselahs, which take a long time to form and eventually stabilize into 
	//period 1 or 2 oscillators.
	
	printf("Your choices for your board are as follows:\n");
	//display the x-board, a methuselah
	MakeX_Board(dim,x_board);
	printf("The x-board: \n");
	displayBoard(dim,x_board);
	//display the pentadecathlon, a period 15 oscillator
	printf("The pentadecathlon(use \"penta\" when selecting a choice):\n");
	makePentBoard(dim,pent_board);
	displayBoard(dim,pent_board);
	//display the R-pentomino, a 1103 lifetime methuselah
	printf("The R-pentomino(use \"R-pent\" when selecting a choice):\n");
	makeRPent(dim,rPent);
	displayBoard(dim,rPent);
	//For board sizes larger than 10x10, more premade board choices become available.
	//These next 4 if statements display the larger board choices that are available.
	
	//display the mathematician board, a period 5 oscillator.
	if(dim >= 11){
		printf("The mathematician(use \"math\" when selecting a choice): \n");
		makeMathematician(dim,mathematician);
		displayBoard(dim,mathematician);
	}
	
	//display the pulsar board, a period 3 oscillator, and the diehard board, a 130 lifetime methuselah.
	if(dim>=15){
		printf("The pulsar:\n");
		makePulsar(dim,pulsar);
		displayBoard(dim,pulsar);
		printf("The diehard:\n");
		makeDieHard(dim,diehard);
		displayBoard(dim,diehard);
	}
	//display the acorn board, a 5206-lifetime methuselah
	if(dim>=20){
		printf("The acorn:\n");
		makeAcorn(dim,acorn);
		displayBoard(dim,acorn);
	}
	//display the queen bee shuttle, a 30 period oscillator.
	if(dim>=22){
		printf("The queen bee shuttle(use \"queen\" when selecting a choice):\n");
		makeQueenBeeShuttle(dim,queenBeeShuttle);
		displayBoard(dim,queenBeeShuttle);
	}
	//These next if statements read the input from the user and choose the appropriate board
	//based on the user's choice.
	printf("Please enter your choice: ");
	string choice = GetLine();
	if(StringEqual("x-board",choice)){
		printf("x-board chosen.  Loading board...\n");
		copyBoard(dim,x_board,board);
	}
	if(StringEqual("penta",choice)){
		printf("pentadecathlon chosen.  Loading board...\n");
		copyBoard(dim,pent_board,board);
	}
	if(StringEqual("acorn",choice)){
		printf("acorn chosen.  Loading board...\n");
		copyBoard(dim,acorn,board);
	}
	if(StringEqual("R-pent",choice)){
		printf("R-pentomino chosen.  Loading board...\n");
		copyBoard(dim,rPent,board);
	}
	if(StringEqual("pulsar",choice)){
		printf("Pulsar chosen.  Loading board...\n");
		copyBoard(dim,pulsar,board);
	}
	if(StringEqual("diehard",choice)){
		printf("diehard chosen.  Loading board...\n");
		copyBoard(dim,diehard,board);
	}
	if(StringEqual("math",choice)){
		printf("Mathematician chosen.  Loading board...\n");
		copyBoard(dim,mathematician,board);
	}
	if(StringEqual("queen",choice)){
		printf("Queen bee chosen.  Loading board...\n");
		copyBoard(dim,queenBeeShuttle,board);
	}
}

//*******************************************************************************************
//NAME: MakeX_Board
//PURPOSE: To make an array into the x-board array, a methuselah of unkown lifetime
//PASSED: int dim: size of the board
//PASSED: bool x_board[dim+2][dim+2]
//RETURNED: void
//*******************************************************************************************

void MakeX_Board(int dim,bool x_board[dim+2][dim+2]){
	int i;
	fillDefault(dim,x_board);
	for(i=1;i<dim+1;i++){
		x_board[i][i]=true;
		x_board[i][dim+1-i]=true;
	}
}

//*******************************************************************************************
//NAME: makePentBoard
//PURPOSE: To make an array into the pentadecathlon board, a period 15 oscillator.
//PASSED: int dim: size of the array
//PASSED: bool pent_board[dim+2][dim+2]: array that represents the board
//RETURNED: void
//*******************************************************************************************

void makePentBoard(int dim,bool pent_board[dim+2][dim+2]){
	fillDefault(dim,pent_board);
	int i,width,height;
	width = (dim/2)+1;
	height = (dim-10)/2;
	pent_board[height+1][width]=true;
	pent_board[height+2][width-1]=true;
	pent_board[height+2][width+1]=true;
	pent_board[height+9][width+1]=true;
	pent_board[height+9][width-1]=true;
	pent_board[height+10][width]=true;
	for(i=height+3;i<height+9;i++){
		pent_board[i][width-2]=true;
		pent_board[i][width+2]=true;
	}
}

//*******************************************************************************************
//NAME: makeAcorn
//PURPOSE: To make an array into the acorn board, a 5206 lifetime methuselah.
//PASSED: int dim: size of the array
//PASSED: bool acorn[dim+2][dim+2]: array that represents the board
//RETURNED: void
//*******************************************************************************************

void makeAcorn(int dim,bool acorn[dim+2][dim+2]){
	int i,width,height;
	fillDefault(dim,acorn);
	width = (dim/2);
	height = width;
	acorn[height][width]=true;
	acorn[height+2][width]=true;
	acorn[height+2][width-1]=true;
	acorn[height+1][width+2]=true;
	acorn[height+2][width+3]=true;
	acorn[height+2][width+4]=true;
	acorn[height+2][width+5]=true;
}

//*******************************************************************************************
//NAME: makeRPent
//PURPOSE: To make an array into the R-pentomino board, a 1103 lifetime methuselah
//PASSED: int dim: size of the array
//PASSED: bool board[dim+2][dim+2]: array that represents the board
//RETURNED: void
//*******************************************************************************************

void makeRPent(int dim,bool board[dim+2][dim+2]){
	fillDefault(dim,board);
	int center; center = dim/2;
	board[center][center]=true;
	board[center+1][center]=true;
	board[center+2][center]=true;
	board[center+1][center-1]=true;
	board[center][center+1]=true; 
}

//*******************************************************************************************
//NAME: makePulsar
//PURPOSE: To make an array into the pulsar board, a period 3 oscillator.
//PASSED: int dim: size of the array
//PASSED: bool board[dim+2][dim+2]: array that represents the board
//RETURNED: void
//*******************************************************************************************

void makePulsar(int dim,bool board[dim+2][dim+2]){
	fillDefault(dim,board);
	int i,j,k,start;
	start = (dim-14)/2;
	for(i=start+3;i<=start+12;i+=6){
		makePulsarRow(dim,board,start+1,i);
		makePulsarRow(dim,board,start+6,i);
		makePulsarRow(dim,board,start+8,i);
		makePulsarRow(dim,board,start+13,i);
		makePulsarColumn(dim,board,i,start+1);
		makePulsarColumn(dim,board,i,start+6);
		makePulsarColumn(dim,board,i,start+8);
		makePulsarColumn(dim,board,i,start+13);
	}
}

//*******************************************************************************************
//NAME: makePulsarRow
//PURPOSE: To make one 3-cell row of the pulsar board
//PASSED: int dim: size of the array
//PASSED: bool board[dim+2][dim+2]: array that represents the board
//PASSED: int startRow: row to start making the 3-cell row in
//PASSED: int startColum: column to start making the 3-cell row in
//RETURNED: void
//*******************************************************************************************

void makePulsarRow(int dim,bool board[dim+2][dim+2],int startRow,int startColum){
	int i;
	for(i=startColum;i<=startColum+2;i++){
		board[startRow][i]=true;
	}
}

//*******************************************************************************************
//NAME: makePulsarColumn
//PURPOSE: To make one 3-cell column of the pulsar board
//PASSED: int dim: size of the array
//PASSED: bool board[dim+2][dim+2]: array that represents the board
//PASSED: int startRow: row to start making the 3-cell column in
//PASSED: int startColum: column to start making the 3-cell column in
//RETURNED: void
//*******************************************************************************************

void makePulsarColumn(int dim,bool board[dim+2][dim+2],int startRow,int startColumn){
	int i;
	for(i=startRow;i<=startRow+2;i++){
		board[i][startColumn]=true;
	}
}

//*******************************************************************************************
//NAME: makeDieHard
//PURPOSE: To make a board into the diehard board, a 130 lifetime methuselah
//PASSED: int dim: size of the array
//PASSED: bool board[dim+2][dim+2]: array that represents the board
//RETURNED: void
//*******************************************************************************************

void makeDieHard(int dim,bool board[dim+2][dim+2]){
	//dim at least 15
	int center;
	fillDefault(dim,board);
	center = dim/2;
	board[center][center-2]=true;
	board[center][center-3]=true;
	board[center+1][center-2]=true;
	board[center-1][center+3]=true;
	board[center+1][center+2]=true;
	board[center+1][center+3]=true;
	board[center+1][center+4]=true;
}

//*******************************************************************************************
//NAME: makeMathematician
//PURPOSE: To make a board into the mathematician board, a 5 period oscillator
//PASSED: int dim: size of the array
//PASSED: bool board[dim+2][dim+2]: array that represents the board
//RETURNED: void
//*******************************************************************************************

void makeMathematician(int dim,bool board[dim+2][dim+2]){
	int start,i;
	fillDefault(dim,board);
	start = (dim - 11)/2;
	board[start+1][start+5]=true;
	board[start+2][start+4]=true;
	board[start+2][start+6]=true;
	board[start+3][start+4]=true;
	board[start+3][start+6]=true;
	board[start+4][start+4]=true;
	board[start+4][start+3]=true;
	board[start+4][start+6]=true;
	board[start+4][start+7]=true;
	board[start+5][start+1]=true;
	board[start+5][start+9]=true;
	board[start+6][start+1]=true;
	board[start+6][start+2]=true;
	board[start+6][start+3]=true;
	board[start+6][start+9]=true;
	board[start+6][start+8]=true;
	board[start+6][start+7]=true;
	for(i=1;i<=9;i++){
		board[start+8][start+i]=true;
	}
	board[start+9][start+1]=true;
	board[start+9][start+9]=true;
	for(i=3;i<=6;i++){
		board[start+10][start+i]=true;
	}
	board[start+11][start+3]=true;
	board[start+11][start+6]=true;
	board[start+11][start+7]=true;
}

//*******************************************************************************************
//NAME: makeQueenBeeShuttle
//PURPOSE: To make a board into the queen bee shuttle board, a 30 period oscillator
//PASSED: int dim: size of the array
//PASSED: bool board[dim+2][dim+2]: array that represents the board
//RETURNED: void
//*******************************************************************************************

void makeQueenBeeShuttle(int dim,bool board[dim+2][dim+2]){
	int height,width;
	width = (dim-21)/2;
	height = dim/2;
	fillDefault(dim,board);
	board[height][width]=true;
	board[height][width+1]=true;
	board[height+1][width]=true;
	board[height+1][width+1]=true;
	board[height][width+5]=true;
	board[height+1][width+6]=true;
	board[height-1][width+6]=true;
	board[height+2][width+7]=true;
	board[height-2][width+7]=true;
	board[height+1][width+8]=true;
	board[height][width+8]=true;
	board[height-1][width+8]=true;
	board[height+2][width+9]=true;
	board[height+3][width+9]=true;
	board[height-2][width+9]=true;
	board[height-3][width+9]=true;
	board[height][width+20]=true;
	board[height][width+21]=true;
	board[height+1][width+20]=true;
	board[height+1][width+21]=true;
}

//*******************************************************************************************
//NAME: copyBoard
//PURPOSE: To copy one board to another
//PASSED: int dim: size of both arrays
//PASSED: bool source[dim+2][dim+2]: board to be copied from
//PASSED: bool destination[dim+2][dim+2]: board to be copied to
//RETURNED: void
//*******************************************************************************************

void copyBoard(int dim,bool source[dim+2][dim+2],bool destination[dim+2][dim+2]){
	int i,j;
	for(i=0;i<dim+2;i++){
		for(j=0;j<dim+2;j++){
			destination[i][j]=source[i][j];
		}
	}
}

//Functions related to the game board manipulation and iterations of the game

//*******************************************************************************************
//NAME: runStage
//PURPOSE: To run one stage of the simulation
//PASSED: int dim: size of the array
//PASSED: bool board[dim+2][dim+2]: array that represents the board.
//RETURNED: void
//*******************************************************************************************

void runStage(int dim,bool board[dim+2][dim+2]){
	//declare all variables, as well as a new int array that holds the values of the number
	//of neighbors a cell has.
	int i,j;
	bool live;
	int neighbor_board[dim][dim];
	//Get the numbers of neighbors that all cells have.
	fillNeighborBoard(dim,neighbor_board,board);
	for(i=1;i<dim+1;i++){
		for(j=1;j<dim+1;j++){
			//for each cell, determine whether it should die, survive, or reproduce into a new cell,
			//based on the following rules:
			//If a live cell has less than 2 neighbors or more than 3 neighbors, it dies.
			//If a dead cell has exactly 3 neighbors, it becomes a live cell.
			if(neighbor_board[i-1][j-1]<2 && board[i][j]){
				board[i][j]=false;
			}
			if(neighbor_board[i-1][j-1]>3 && board[i][j]){
				board[i][j]=false;
			}
			if(neighbor_board[i-1][j-1]==3 && !board[i][j]){
				board[i][j]=true;
			}
		}
	}
}

//*******************************************************************************************
//NAME: fillDefault
//PURPOSE: To fill a board with a blank slate, with every cell being dead.
//PASSED: int dim: size of the array
//PASSED: bool board[dim+2][dim+2]: array that represents the board
//RETURNED: void
//*******************************************************************************************

void fillDefault(int dim,bool board[dim+2][dim+2]){
	int i,j;
	for(i=0;i<dim+2;i++){
		for(j=0;j<dim+2;j++){
			board[i][j]=false;
		}
	}
	
}

//*******************************************************************************************
//NAME: fillNeighborBoard
//PURPOSE: To fill an integer board with the number of neighbors each cell has.
//PASSED: int dim: size of the array
//PASSED: int neighbor_board[dim][dim]: array to be filled with the number of neighbors each cell has.
//PASSED: bool board[dim+2][dim+2]: array to get the number of neighbors from each cell.
//RETURNED: void
//*******************************************************************************************

void fillNeighborBoard(int dim,int neighbor_board[dim][dim],bool board[dim+2][dim+2]){
	int i,j,ne;
	for(i=1;i<dim+1;i++){
		for(j=1;j<dim+1;j++){
			ne = getNeighbors(dim,i,j,board);
			neighbor_board[i-1][j-1]=ne;
		}
	}
}

//*******************************************************************************************
//NAME: getNeighbors
//PURPOSE: To get the number of neighbors a cell has
//PASSED: int dim: size of the array
//PASSED: int x: x-coordinate of cell to search
//PASSED: int y: y-coordinate of cell to search
//PASSED: bool board[dim+2][dim+2]: array that represents the board.
//RETURNED: int ne: number of neighbors a cell has
//*******************************************************************************************

int getNeighbors(int dim,int x,int y,bool board[dim+2][dim+2]){
	//Check all of the neighboring cells, if they have live creatures, increase the variable ne.
	//At the end of the function, ne is returned.
	int ne = 0;
	if(board[x+1][y+1])ne++;
	if(board[x][y+1])ne++;
	if(board[x-1][y+1])ne++;
	if(board[x+1][y])ne++;
	if(board[x-1][y])ne++;
	if(board[x-1][y-1])ne++;
	if(board[x][y-1])ne++;
	if(board[x+1][y-1])ne++;
	return ne;
}

//*******************************************************************************************
//NAME: GetLivingCells
//PURPOSE: To get the number of living cells in a board
//PASSED: int dim: size of the array
//PASSED: bool board[dim+2][dim+2]: array that represents the board.
//RETURNED: unsigned long int living: number of living cells on the board.
//*******************************************************************************************

unsigned long int GetLivingCells(int dim,bool board[dim+2][dim+2]){
	unsigned long int living=0,i,j;
	for(i=1;i<dim+1;i++){
		for(j=1;j<dim+1;j++){
			if(board[i][j]){
				living ++;
			}
		}
	}
	return(living);
}

