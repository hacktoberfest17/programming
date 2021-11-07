#include<stdio.h>
#include<conio.h>
 
int result[1000] = {0};

int fact_dp(int n)
{
  	if(n<=1)return 1;
    return n*fact_dp(n-1);
}

int main()
{
	clrscr();
	int n;
	printf("Enter a number : ");
	scanf("%d",&n);
	if(n<=0)
		printf("1\n");
	else
		printf("\nFactorial of the given number is :%d",fact_dp(n));
}
