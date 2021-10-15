#include<stdio.h>
void main()
{
	int n,i,a[50];
	a[0]=0,a[1]=1;
	printf("Enter the n value of the fibonacci series:");
	scanf("%d",&n);
	printf("\nThe fibonacci series is:");
	printf("0\t,1\t");
	for(i=2;i<n;i++)
	{
		a[i]=a[i-1]+a[i-2];
		printf(",\t%d",a[i]);
	}
}

