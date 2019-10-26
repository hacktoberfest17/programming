#include<iostream>
using namespace std;

void swap(int* a, int* b)
{
    int t = *a;
    *a = *b;
    *b = t;
}
 
int partition (int arr[], int low, int high)
{
    int pivot = arr[high];  
    int i = (low - 1); 
    for (int j = low; j <= high- 1; j++)
    {
        if (arr[j] <= pivot)
        {
            i++;  
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}
 
void quickSort(int arr[], int low, int high)
{
    if (low < high)
    {   
        int p = partition(arr, low, high);
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }
}
 
void printArray(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
        cout<<arr[i]<<" ";
}
 
int main()
{
    int arr[100],n;
    cout<<"Enter the size of array : \n";
    cin>>n;
    cout<<"Enter the elements : \n";
    for(int i=0; i<n ; i++){
        cin>>arr[i];
        }
    quickSort(arr, 0, n-1);
    cout<<"Sorted Array : \n";
    printArray(arr, n);
    return 0;
}
