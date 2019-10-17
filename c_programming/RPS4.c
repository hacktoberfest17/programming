#include <stdio.h>
struct players
{
	char name[20];
	int playerscore;
}player;
int play(int *S1,int *S2)//### Rock=1 ; Paper=2 ; Scissor=3 ###
{
	char per[50];
	int com;
	srand(time(NULL));
	com = rand()%3+1;
	puts("\nRock Paper or Scissor ?");
	printf("Your Choice: ");gets(per);fflush(stdin);
	if(strcmp(per,"rock")==0)
	{	if(com == 1)
		{	puts("Your Opponent: rock");puts("DRAW");	}
		else if(com == 2)
		{	puts("Your Opponent: paper");puts("Computer won");*S2+=1;	}
		else if(com == 3)
		{	puts("Your Opponent: scissor");puts("You won");*S1+=1;	}
	}
	else if(strcmp(per,"paper")==0)
	{	if(com == 1)
		{	puts("Your Opponent: rock");puts("You won");*S1+=1;	}
		else if(com == 2)
		{	puts("Your Opponent: paper");puts("DRAW");	}
		else if(com == 3)
		{	puts("Your Opponent: scissor");puts("Computer won");*S2+=1;	}
	}
	else if(strcmp(per,"scissor")==0)
	{	if(com == 1)
		{	puts("Your Opponent: rock");puts("Computer won");*S2+=1;	}
		else if(com == 2)
		{	puts("Your Opponent: paper");puts("You won");*S1+=1;	}
		else if(com == 3)
		{	puts("Your Opponent: scissor");puts("DRAW");	}
	}
	else
	puts("You have to type 'rock';'paper';'scissor'.");

}
char info()
{
	printf("Please Enter Your Name:  ");
	scanf("%s",player.name);
	fflush(stdin);
}
char start()
{
	char ans[10];
	int perScore,comScore=0;
	info();
	do
		{
			play(&perScore,&comScore);
			player.playerscore = perScore; 
			puts("Do you want to continue? (Y/N)");
			printf("Type 'score' to see your score.....:");
			gets(ans);
			fflush(stdin); 
			if(strcmp(ans,"score")==0)
			{ 
				printf("\nYour Score: %d\n",perScore);
				printf("Your Opponent's Score: %d\n\n",comScore);
				puts("Do you want to continue? (Y/N)");
				gets(ans);
				if(strcmp(ans,"n")==0)
				{	break;	}
			}
			else if(strcmp(ans,"n")==0)
			break;
		}while(ans != "N");
}
void warning()
{
	char ans;
	puts("Please Only  Press P or H!!!");
	puts("IF you don't want to play please press N....");
	ans = getch();
	switch(ans)
	{
		case 'p':
		case 'P':
			start();
		break;
		case 'n':
		case 'N':
			break;
	}
	
}
showscore()
{
	char ans;
	int n,n1;
	FILE *base;
	if((base=fopen("Scores.txt","r+"))==NULL)
		printf("ERROR");
		
		fprintf(base,"%s",player.name);
		fprintf(base,"%d",player.playerscore);
				
		printf("Name");
		printf("                      ");
		printf("Score\n\n");
		fscanf(base,"%s",&player.name);
		printf("                      ");
		fscanf(base,"%d\n",&player.playerscore);

		printf("\n\nDo you want to play ? (Y/N)\n\n");
		ans = getch(); 
		switch(ans)
		{
			case 'y':
			case 'Y':
				start();
			break;
			case 'n':
			case 'N':
			break;
			default:
				warning();
		}
	fclose(base);
}
	
void main()
{
	char ans1;
	puts("Welcome to Rock Paper Scissor Game!!!");
	puts("Press P to play");
	puts("Press H to show The Score Board");
	ans1 = getch();
	fflush(stdin);
	switch(ans1)
	{
		case 'P':
		case 'p':
		start();
		break;
		case 'H':
		case 'h':
		showscore();
		break;
		default:
		warning();
	}
}		
