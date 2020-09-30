#include<stdio.h>
int main()
{
    int num;
    printf("Enter the number whose table you want to see:\n");
    scanf("%d",&num);
    printf("The Multiplication Table of %d is:\n",num);
    for (int i = 1; i <= 10; i++)
    {
        printf("%d x %d = %d\n", num, i, num * i);
    }
    
    return 0;
}