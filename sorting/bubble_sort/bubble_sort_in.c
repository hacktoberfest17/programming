#include<stdio.h>

void main()
{
    int i,j,n,tem;

    printf("Enter number of elements:");

    scanf("%d",&n);

    int arr[n];

    for(i=0;i<n;i++)
    {
        printf("Enter element no %d :",i+1);
        scanf("%d",&arr[i]);
    }

    for(i=0;i<n-1;i++)
    {
        for(j=0;j<n-1-i;j++)
        {
            if(arr[j]>arr[j+1])
            {
                tem = arr[j];
                arr[j]=arr[j+1];
                arr[j+1] = tem;
            }

        }
    }
    printf("Sorted list :");

    for(i=0;i<n;i++){
        printf("%d ",arr[i]);
    }

}
