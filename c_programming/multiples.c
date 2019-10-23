#include <stdio.h>         		                           \\Including Header Files
#include<conio.h>

#define MAX 1000				                           \\Macros : Replaces variable names with designated values.
#define THREE 3
#define FIVE 5

int main()
{
	int i;
	int multiplesOf3;                                       \\Written in CamelCase type
	int multiplesOf5;
	int sum;

	for(i = 1; i < 10; i++)
	{
		multiplesOf3 = THREE * THREE;                        \\THREE is replaced by 3, at time of execution.
		multiplesOf5 = FIVE * FIVE;                          \\FIVE is replaced by 5, at time of execution.
		printf("Multiple of 3: %d\n", multiplesOf3);
		printf("Multiple of 5: %d\n", multiplesOf5);
	}

return 0;
}
