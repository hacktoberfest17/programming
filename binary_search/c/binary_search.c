#include<stdio.h>

int binarySearch(int arr[], int l, int r, int x)
{
    if (x > arr[r]) {	// outside bounds
    	return -1;
    }
    int mid = (l + r)/2;
 
    if (arr[mid] == x)  
	return mid;
 
    if (arr[mid] > x) 
	binarySearch(arr, 0, mid-1, x);

    else  
	binarySearch(arr, mid+1, r, x);
}
 
int main(void)
{
   int arr[10],i,x;
   printf("Enter the elements of the array : \n");
   for(i=0 ; i<10 ; i++){
   	scanf("%d",&arr[i]);
   }
   int n = sizeof(arr)/ sizeof(arr[0]);
   printf("Enter the element to be searched : \n");
   scanf("%d",&x);
   int result = binarySearch(arr, 0, n-1, x);
   (result >= 0 & result <= n-1) ? printf("Element is present at index %d", result)
                 : printf("Element is not present");
   return 0;
}
