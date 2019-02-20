// Leap year checking 
#include <stdio.h>
void main()
{
	int a;
	printf("Enter year: ");
	scanf("%d",&a);
	if(a%4==0)
	{
		if(a%100==0)
		{
			if(a%400==0)
			{
			printf("The year is Leap Year");
			}
			else
			{
			printf("The year is not Leap Year");
			}
		}
		else
		{
		printf("The year is Leap Year");	
		}
	}
	else 
		printf("The year is not Leap Year");

}	
