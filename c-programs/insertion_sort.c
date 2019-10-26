#include <stdio.h>
int main()
{
	int K,b,n,a[n];
	scanf("%d",&n);
	for (i = 0; i < n; i++)
	{
		scanf("%d",&a[i]);
	}
	for (i = 0; i < n; ++i)
	{
		K=i,b=a[i];
		while((b<a[K-1])&&(K>0)){
			a[K]=a[K-1];
			K--;
		}
		a[K]=b;
	}
	for (i = 0; i < n; i++)
	{
		printf("%d\n",a[i] );
	}
	return 0;
}