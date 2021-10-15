#include<stdio.h>
void main()
{
	int num,sq,sq1,flag=0;
	int i,rem,rev=0,rev1=0,re,sum;
	printf("Enter the number:");
	scanf("%d",&num);
	sq=num*num;
	sq1=sq;
	if(sq==0)
	{
		printf("Enter a valid input");
	}
	while(sq>0)
	{
		if(sq!=0)
		{
			flag++;
			sq=sq/10;
		}
	}
	if(flag%2==0)
	{
		for(i=flag;i>flag/2;i--)
		{
			rem=sq1%10;
			rev=rev*10+rem;
			sq1=sq1/10;
		}
		while(rev>0)
		{
			re=rev%10;
			rev1=rev1*10+re;
			rev=rev/10;
		}
		sum=sq1+rev1;
		if(num==sum)
		printf("%d is a kaprekar number",num);
		else
		printf("%d is not a kaprekar number",num);
	}
	else
	printf("%d is not a kaprekar number",num);
}
