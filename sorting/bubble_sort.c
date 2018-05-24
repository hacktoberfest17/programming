#include <stdio.h>
 
void main()
{
    int i,j,a;
 
    printf("Enter no of numbers\n");
    scanf("%d", &n);
    int number[n];
    printf("Enter the numbers \n");
    for (i = 0; i < n; ++i)
        scanf("%d", &number[i]);
    for (i = 0; i < n; i++)
    {
        for (j = i + 1; j < n; j++)
        {
            if (number[i] > number[j])
            {
                a =  number[i];
                number[i] = number[j];
                number[j] = a;
            }
        }
    }
   printf("after sort");
   for(i=0 ; i<n ; i++)
   {
   printf("%d",number[i]);
   }
}
