#include<stdio.h>
int main(){
	#define AREA(X1,X2,X3,Y1,Y2,Y3) (X1*(Y2-Y3)-Y1*(X2-X3)+(X2*Y3-Y2*X3))
	int a,b,c,d,e,f;
	scanf("%d %d %d %d %d %d",&a,&b,&c,&d,&e,&f);
	if(AREA(a,b,c,d,e,f)==0)
	printf("Points are collinear");
	else
	printf("Points are non-collinear");
}