#include<stdio.h>
int fibo(int x);
void main(){
	int i, n,res;
printf("Enter A Number:");
scanf("%d",&n);
for(i=1;i<=n;i++){
 res=fibo(i);
 printf("%d, ",res);
  }
}
int fibo(int x){
  if(x==1 || x==2)
    return 1;
  else
    return fibo(x-1) + fibo(x-2);
}
