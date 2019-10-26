#include <stdio.h>
int main(){
	int n,a[n],i,j,flag,b;
	scanf("%d\n",&n);
	for (i = 0; i < n; ++i)
	{
		scanf("%d",&a[i]);
	}
	for (i = 0; i < n-1; i++)
	{
		flag=0;
		for (j = 0; j < n-1; j++)
		{
			if (a[j]>a[j+1])
			{
				b=a[j];
				a[j]=a[j+1];
				a[j+1]=b;
				flag=1;
			}
		}
	}
	for (i = 0; i < n; ++i)
	{
		printf("%d\n",a[i]);
	}
}