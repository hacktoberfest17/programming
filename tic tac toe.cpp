#include<stdio.h>
#include<stdlib.h>
char box[10]={'1','2','3','4','5','6','7','8','9'};
void creating_board();
void marking_board(int,char);
int check_winner();
main()
{
	
int choice,player=1,i;
char mark;
do
{ 
    system("cls");
	creating_board();
	player=(player%2)?1:2;
	
	printf("Player %d , Enter your number : ",player);
	scanf("%d",&choice);
	
	mark= (player==1)?'X':'O';
	
	marking_board(choice,mark);
	i=check_winner();
	player++;
	}while(i==-1);	
	
	creating_board();
	if(i==1)
	{ printf("Player %d has won the match",--player);
	}
	else
	{
		printf("<-------DRAW------>");
	}
}
void creating_board()
{
		printf("\t\t\t\t\t\t TIC TAC TOE ");
	printf("\n \t\t\t\t\t DEVELOPED BY SHASWAT PANDEY\n\n\n");
	
	printf("PLAYER 1 --> [X]");
	printf("PLAYER 2 --> [O]");
	printf("\n\n");

	printf("  %c |  %c     |  %c   \n",box[0],box[1],box[2]);
	printf(" ___|________|______\n");
	printf("    |        |      \n");
	printf("  %c |  %c     |  %c   \n",box[3],box[4],box[5]);

    printf(" ___|________|______\n");
	printf("  %c |  %c     |  %c   \n",box[6],box[7],box[8]);
	printf("    |        |      \n");
}

void marking_board(int choice ,char mark)
{
	if(choice==1 && box[0]=='1')
	    box[0]=mark;
	  else  if(choice==2 && box[1]=='2')
	    box[1]=mark;
	    else  if(choice==3 && box[2]=='3')
	    box[2]=mark;
	    else  if(choice==4 && box[3]=='4')
	    box[3]=mark;
	    else  if(choice==5 && box[4]=='5')
	    box[4]=mark;
	    else  if(choice==6 && box[5]=='6')
	    box[5]=mark;
	    else  if(choice==7 && box[6]=='7')
	    box[6]=mark;
	    else  if(choice==8 && box[7]=='8')
	    box[7]=mark;
	      else  if(choice==9 && box[8]=='9')
	    box[8]=mark;
	    else
	    {
	
	    printf("\n\nInvalid choice");
	    	}
}


int check_winner()
{
	if(box[0]==box[1] && box[1]==box[2])
	  return(1);
	 else if(box[3]==box[4] && box[4]==box[5])
	  return(1);
	  else if(box[6]==box[7] && box[7]==box[8])
	  return(1);
	  else if(box[0]==box[3] && box[3]==box[6])   //HORIZONTALLY
	  return(1);
	  else if(box[1]==box[4] && box[4]==box[7])
	  return(1);
	  else if(box[2]==box[5] && box[5]==box[8])
	  return(1);
	  else if(box[0]==box[4] && box[4]==box[8])  //DIAGONALLY
	  return(1);
	  else if(box[2]==box[4] && box[4]==box[6])
	  return(1);
	  
	  else if(box[0]!='1' && box[1]!='2' && box[2]!='3' && box[3]!='4' && box[4]!='5' && box[5]!='6' && box[6]!='7' && box[7]!='8' && box[8]!='9')
	     return(0);
	   else
	   return(-1);  
}
