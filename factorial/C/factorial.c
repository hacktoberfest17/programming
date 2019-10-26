#include<stdio.h>
#include<conio.h>
 
int result[1000] = {0};

int fact_dp(int n)
{
    int i;
    result[0] = 1;
    for (i = 1; i <= n; ++i) 
    {
    	result[i] = i * result[i - 1];
    }
    
    return result[n];
}

int main()
{
	clrscr();
	int n;
	printf("Enter number: ");
	scanf("%d",&n);
	if(n<=0)
	{
		printf("cannot be found");
	}
	else
	{
		printf("\nFactorial of the number is :%d",fact_dp(n));
	}
}
