//Checks if a number is Prime or not

#include <stdio.h>
#include <math.h>

void main()
{
    long long num,root,i;
    int flag=1;//1 signifies prime,0 signifies not a prime

    scanf("%llu",&num);

    root=sqrt(num)+1;

    for(i=2;i<root;i++)
    {
        if(num%i==0)
        {
            flag=0;
            break;
        }
    }

    if(flag==1) printf("This is a prime number.");
    else printf("This is not a prime number.");
}
