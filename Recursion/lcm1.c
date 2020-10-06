#include<stdio.h>
int lcm(int,int);
int max;
main()
{
    int x,y,z;
    printf("Enter the value of x:\n");
    scanf("%d",&x);
    printf("Enter the value of y:\n");
    scanf("%d",&y);
    max=x>y?x:y;
    z=lcm(x,y);
    printf("The lcm of %d and %d is %d.\n",x,y,z);
}
int lcm(int a,int b)
{
    if(max%a==0&&max%b==0)
    {
        return max;
    }
    max++;
    lcm(a,b);
}
