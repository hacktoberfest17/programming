#include<stdio.h>
int gcd(int,int);
int min;
main()
{
    int x,y;
    printf("Enter the value of x:\n");
    scanf("%d",&x);
    printf("Enter the value of y:\n");
    scanf("%d",&y);
    min=x>y?y:x;
    printf("The GCD of %d and %d is %d.\n",x,y,gcd(x,y));
}
int gcd(int a,int b)
{
    if(a%min==0&&b%min==0)
    {
        return min;
    }
    min--;
    gcd(a,b);
}
