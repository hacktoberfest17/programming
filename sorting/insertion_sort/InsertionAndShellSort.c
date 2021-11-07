#include<stdio.h>
void shellsort(int a[],int n)
{
	int i,j,step;
	int temp;
	for(step=n/2;step>0;step=step/2)
		for(i=step;i<n;i++)
		{
			temp=a[i];
			for(j=i;j>=step;j=j-step)
				if(temp<a[j-step])
					a[j]=a[j-step];
				else
					break;
				a[j]=temp;
		}

}
void insertion_sort(int a[],int n)
{
	int i,j,temp;
	for(i=1;i<n;i++)
	{
		temp=a[i];
		for(j=i-1;j>=0&&a[j]>temp;j--)
			a[j+1]=a[j];
		a[j+1]=temp;
	}
}
void main()
{
	int a[30],n,i,choice;
	clrscr();
	printf("Enter the no.of elements : ");
	scanf("%d",&n);
	printf("Enter the elements of the array: ");
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
	}
	printf("\nMenu:\n1.InsertionSort\n2.ShellSort\n");
	printf("Enter your choice ");
	scanf("%d",&choice);
	switch(choice)
	{
		case 1:
			printf("Array sorted using the Insertion sort\n");
			insertion_sort(a,n);
			for(i=0;i<n;i++)
			{
				printf("%d\t",a[i]);
			}
			break;
		case 2:
			printf("Array sorted using the SHELL sort\n");
			insertion_sort(a,n);
			for(i=0;i<n;i++)
			{
				printf("%d\t",a[i]);
			}
			break;
	}
}