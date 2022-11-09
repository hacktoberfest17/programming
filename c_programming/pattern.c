#include <stdio.h>

/*  1
   123
  12345
 1234567
123456789
 1234567
  12345
   123
    1
*/
int main()
{
	int i,j,n,k;
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		for(j=i;j<n;j++)
		{
			printf(" ");
		}
		for(k=1;k<i*2;k++)
		{
			printf("%d",k);
		}
		printf("\n");
		
	}
	for(i=n;i>=1;i--)
	{
		for(j=n;j>i;j--)
		{
			printf(" ");
		}
		for(k=1;k<i*2;k++)
		{
			printf("%d",k);
		}
		printf("\n");
		
	}
	return 0;
}