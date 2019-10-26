#include <stdio.h>
#include <stdlib.h>
#define MAX 100

void swap(int *a, int *b)
{
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
}

int partion(int arr[], int low, int high)
{
    int pivotIndex = low + rand()%(high - low + 1);
    int pivot,j;
    int i = low - 1;
    pivot = arr[pivotIndex];
    swap(&arr[pivotIndex], &arr[high]);
    for (j = low; j < high; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            swap(&arr[i], &arr[j]);
        }
 
    }
    swap(&arr[i+1], &arr[high]);
    return i + 1;
}
 
void quick_sort(int arr[], int low, int high)
{
    int p;
    if (low < high)
    {
        p = partion(arr, low, high);
        quick_sort(arr, low, p-1);
        quick_sort(arr, p+1, high);
    }
}

int main()
{
    int i,n,arr[MAX];
    printf("Enter the size of the array : \n");
    scanf("%d",&n);
    printf("Enter the elements : \n");
    for (i = 0; i < n; i++)
        scanf("%d",&arr[i]);
    quick_sort(arr, 0, n-1); 
    printf("Sorted Array : \n");
    for (i = 0; i < n; i++)
         printf("%d \n", arr[i]);
    return 0;
}
