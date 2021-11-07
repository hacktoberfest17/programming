#include<stdio.h>
void main()
{
	int n,i,j,l,max,original[10][10],negation[10][10];
	int power[10]={1,2,4,8,16,32,64,128,256,512};
	printf("\n Enter dimension of image matrix:");
	scanf("%d",&n);
	//accepting original image
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		{
			scanf("%d",&original[i][j]);
		}
		printf("\n");
	//finding largest value
	max=original[0][0];
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		{
			if(original[i][j]>max)
				max=original[i][j];
		}
	//finding l
	for(i=0;i<10;i++)
		if(max<power[i])
		{
			l=power[i];
			break;
		}
	//subtracting values
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			original[i][j]=(l-1)-original[i][j];

	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		{
			printf("%d ",original[i][j]);
		}
		printf("\n");
		
}