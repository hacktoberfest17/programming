#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n;
	printf("Enter the no. of enteris in the array:\t");
	scanf("%d",&n);
	int *a = (int *)malloc(sizeof(int) * n);
	long int s=0;
	printf("\n\n\nEnter the values.\n\n\n");
	for(int i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
		s=s+a[i];
	}

	printf("\n\nThe sum of all the elements is:\t\t%ld\n\n",s);
}
