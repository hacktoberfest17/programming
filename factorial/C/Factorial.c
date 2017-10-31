#include<stdio.h>
int facto(int x);
void main(){
  int n;
  long long int fac;
  printf("Enter an integer: ");
  scanf("%d",&n);
  fac=facto(n);
  printf("%lld",fac);
}
int facto(int x){
 if(x==0 || x==1)
  return 1;
 else
  return x*facto(x-1);
}
