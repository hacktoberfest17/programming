#include <stdio.h>
#include <stdlib.h>

long long int fac(int v)
{
	if(v==1) return v;
	return v*fac(v-1);
}

int main()
{
	int num;
  printf("Enter the number whose factorial is to be calculated:\t");
	scanf("%d",&num);
	long long int fac_value;
	fac_value=fac(num);
  printf("Factorial value of %d is:\n",num);
	printf("%Ld\n",fac_value);
	
	return 0;
}
