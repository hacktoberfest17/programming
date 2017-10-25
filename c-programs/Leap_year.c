#include<stdio.h>
int main(){
	int i;
	scanf("%d",&i);
	if((i%4)&&(i%100==0)||(i%400==0)){
	printf("Year is leap");
	}
	else if((i%4!=0)||(i%100!=0)||(i%400!=0)){
	printf("YEAR IS NOT LEAP");
	}
}