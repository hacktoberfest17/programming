#include<stdio.h>
int main()
{
	int a,i,n,fact=1;
	scanf("%d",&n);
	if(n>=0)
	{
for(i=1;i<=n;i++)
{
	fact=fact*i;
}
printf("%d",fact);
}
else
printf("Factorial not defined");
}
