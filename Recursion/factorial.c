#include<stdio.h>
int sum(int);
main()
{
   int x,z;
   printf("Enter the value of x:\n");
   scanf("%d",&x);
   z=sum(x);
   printf("The sum of %d numbers is %d.\n",x,z);
}
int sum(int a)
{
    int s;
    if(a==1)
        return(a);
    s=a*sum(a-1);
    return(s);
}

