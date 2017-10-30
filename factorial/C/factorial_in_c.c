#include<stdio.h>
int factorial(int n)
int main()
  int n;
scanf("%d",&n);
printf("%d",factorial(int n));

int multiplyNumbers(int n)
{
    if (n >= 1)
        return n*multiplyNumbers(n-1);
    else
        return 1;
}


