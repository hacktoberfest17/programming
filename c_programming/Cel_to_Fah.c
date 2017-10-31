#include<stdio.h>
void main(){
int cel, fah;
printf("Input a Value in Celsius: ");
scanf("%d",&cel);
fah=cel*(9/5)+32;
printf("%d Celsius = %d Fahrenheits",cel,fah);
}
