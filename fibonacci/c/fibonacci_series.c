#include<stdio.h>
 
int Fibo(int);
 
int main()
{
   int n, i = 0, j;
 
   scanf("%d",&n);

   for ( j = 1 ; j <= n ; j++ )
   {
      printf("%d\n", Fibo(i));
      i++; 
   }
 
   return 0;
}
 
int Fibo(int n)
{
   if ( n == 0 )
      return 0;
   else if ( n == 1 )
      return 1;
   else
      return ( Fibonacci(n-1) + Fibonacci(n-2) );
} 
