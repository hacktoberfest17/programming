// Merge Sort

/*  About Merge Sort

Merge sort is a sorting technique based on divide and conquer technique. With worst-case time complexity being Ο(n log n), it is one of the most respected algorithms.

Merge sort first divides the array into equal halves and then combines them in a sorted manner.

*/


#include<bits/stdc++.h>
using namespace std;

void merge(int *,int, int , int );

void merge_sort(int *arr, int low, int high)
{
    int mid;
    if (low < high)
    {
    
        //divide the array at mid and sort independently using merge sort
        mid=(low+high)/2;
        merge_sort(arr,low,mid);
        merge_sort(arr,mid+1,high);
        
        //merge or conquer sorted arrays
        merge(arr,low,high,mid);
    
    }
}

// Merge sort 

void merge(int *arr, int low, int high, int mid)
{
    int i, j, k, c[50];
    i = low;
    k = low;
    j = mid + 1;
    while (i <= mid && j <= high) {
        if (arr[i] < arr[j]) {
            c[k] = arr[i];
            k++;
            i++;
        }
        else  {
            c[k] = arr[j];
            k++;
            j++;
        }
    }
    while (i <= mid) {
        c[k] = arr[i];
        k++;
        i++;
    }
    while (j <= high) {
        c[k] = arr[j];
        k++;
        j++;
    }
    for (i = low; i < k; i++)  {
        arr[i] = c[i];
    }
}

// read input array and call mergesort

int main()
{
    int arr[30], num;
    
	cout<<"Enter number of elements to be sorted: ";
    cin>>num;
    cout<<"Enter "<<num<<" elements to be sorted: ";
    
	for (int i = 0; i < num; i++)
	{
		cin>>arr[i];
    }
    
    merge_sort(arr, 0, num-1);
    
	cout<<"Sorted array\n";
    for (int i = 0; i < num; i++)
    {
        cout<<arr[i]<<"\t";
    }
}
