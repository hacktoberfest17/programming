#include<stdio.h>

int main()
{
	int BirthMonth, BirthYear;
	int CurrentMonth, CurrentYear;
	int AgeYear, AgeMonth;
	
	printf("\n\n\t\t\tCount the age person\n\n");
	printf("Enter Your Birth Year(Eg:1989):");
	scanf("%d",&BirthYear);
	
	printf("\n\nEnter Your Birth Month(Eg:07):");
	scanf("%d",&BirthMonth);
	
	printf("\nEnter The Current Month(Eg:07):");
	scanf("%d",&CurrentMonth);
	
	printf("\nEnter The Current Year(Eg:2010):");
	scanf("%d",&CurrentYear);
	
	AgeYear=CurrentYear-BirthYear;
	AgeMonth=CurrentMonth-BirthMonth;
	if(AgeMonth/10==0)
		printf("\n\n\t\tYour Age is %d Years And 0%d Months ",AgeYear,AgeMonth);
	else
		printf("\n\n\t\tYour Age is %d Years And %d Months ",AgeYear,AgeMonth);
	return 0;
}
