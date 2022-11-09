#include<stdio.h>
void main(){
  int n,fac;
  printf("Enter an integer: ");
  scanf("%d",&n);
  fac=facto(n);
}
int facto(int x){
 if(x==0 || x==1)
  return 1;
 else
  return x*facto(x-1);
}
