#include<stdio.h>

int binarySearch(int arr[], int l, int r, int x)
{
   if (r >= l)
   {
        int mid = l + (r - l)/2;
 
        if (arr[mid] == x)  return mid;
 
        if (arr[mid] > x) return binarySearch(arr, l, mid-1, x);
 
        return binarySearch(arr, mid+1, r, x);
   }
   return -1;
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
   (result == -1)? printf("Element is not present in array")
                 : printf("Element is present at index %d", result);
   return 0;
}
