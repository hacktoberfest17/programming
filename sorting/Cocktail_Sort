// C++ implementation of Cocktail Sort
#include<bits/stdc++.h>
using namespace std;
 
void CocktailSort(int a[], int n)
{
    bool swapped = true;
    int start = 0;
    int end = n-1;
 
    while (swapped)
    {
        
        swapped = false;
 
        for (int i = start; i < end; ++i)
        {
            if (a[i] > a[i + 1])
            {
                swap(a[i], a[i+1]);
                swapped = true;
            }
        }

        if (!swapped)
            break;
        swapped = false;
 

        --end;
 
        for (int i = end - 1; i >= start; --i)
        {
            if (a[i] > a[i + 1])
            {
                swap(a[i], a[i+1]);
                swapped = true;
            }
        }
 
        // increase the starting point, because
        // the last stage would have moved the next
        // smallest number to its rightful spot.
        ++start;
    }
}
 
void printArray(int a[], int n)
{
    for (int i=0; i<n; i++)
        printf("%d ", a[i]);
    printf("\n");
}
 
int main()
{
    int arr[] = {5, 1, 4, 2, 8, 0, 2};
    int n = sizeof(arr)/ sizeof(arr[0]);
    CocktailSort(a,n);
    printf("Sorted array :\n");
    printArray(a,n);
    return 0;
}
