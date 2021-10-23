#include<stdio.h>
void main()
{
	int rem,num,rev=0,temp;
	printf("Enter the number:");
	scanf("%d",&num);
	temp=num;
	while(num>0)
	{
		rem=num%10;
		rev=rev*10+rem;
		num=num/10;
	}
	printf("The reverse of the number is %d:",rev);
	if(temp==rev)
		printf("The given number %d is a palindrome:",temp);
	else
		printf("The given number %d is not a palindrome:",temp);
}
