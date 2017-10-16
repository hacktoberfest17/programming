#include <stdio.h>
int main(int argc, char const *argv[])
{

    int year=0;

    printf("What year were you born?\n");
    scanf("%d",&year);

    printf("You are %d years old.\n",2017-year);
    return 0;
}
