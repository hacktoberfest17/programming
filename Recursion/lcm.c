#include<stdio.h>
int  lcm(int,int);
main()
{
    int x,y,ans;
    printf("Enter the value of x:\n");
    scanf("%d",&x);
    printf("Enter the value of y:\n");
    scanf("%d",&y);
    ans=lcm(x,y);
    printf("The lcm of %d and %d is %d.\n",x,y,ans);
}
int lcm(int a,int b)
{
    static int comm=1;//value of comm remains present till the end of programs i.e it doesn't get overwrite.
    if(comm%a==0&&comm%b==0)
   {
      return comm;
   }
   comm++;
   lcm(a,b);
}
