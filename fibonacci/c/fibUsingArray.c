#include<stdio.h>
#include<conio.h>

int main()
{
    int i, n;
    char ch;
    int f[n];

    printf("Enter total number of terms: ");
    scanf("%d", &n);
    
    while((ch = getchar()) != '\n' && ch != EOF);
    {
        f[0] = 0, f[1] = 1;                                 //starts by adding 0 and 1.

        for(i=2; i<n; i++)
        {
            f[i] = f[i-1] + f[i-2];                         //last 2 obtained terms are added to get the next one.
            printf("f[%d]: %d \n", i, f[i]);
        }    
    }
return 0;
}