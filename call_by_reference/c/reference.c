#include <stdio.h>

void swap(int *x, int *y)
{
	int temp;
	temp=*x;
	*x=*y;
	*y=temp;
}

int main()
{
	int r1,r2;
	printf("Enter reference integer 1: ");
	scanf("%d", &r1);
	printf("Enter reference integer 2: ");
	scanf("%d", &r2);
	
	printf("Prior to swap by reference: r1:%d, r2:%d\n",r1,r2);
	swap(&r1,&r2);
	printf("Post to swap by reference: r1:%d, r2:%d\n",r1,r2);
	
	return 0;
}
