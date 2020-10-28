#include <stdio.h>
#include<conio.h>

    int main()
    {
        clrscr(); //this will clear the screen for fresh output & erase the previous output
        int i, n, t1 = 0, t2 = 1, nextTerm;


        printf("Enter the number of terms: ");
        scanf("%d", &n);


        printf("Fibonacci Series: ");


        for (i = 1; i <= n; ++i)  // loop for printing fibonacci series
        {
            printf("%d, ", t1);
            nextTerm = t1 + t2;
            t1 = t2;
            t2 = nextTerm;
        }
        return 0;
    }
