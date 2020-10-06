#include<stdio.h>
int power(int,int);
main()
{
    int x,y,z;
    printf("Enter the value of x:\n");
    scanf("%d",&x);
    printf("Enter the value of y:\n");
    scanf("%d",&y);
    z=power(x,y);
    printf("The answer is %d.",z);
}
int power(int a,int b)
{
    int s;
    if(b==1)
        return a;
    s=a*power(a,b-1);
    return s;
}

