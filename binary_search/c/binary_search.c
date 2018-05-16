#include<stdio.h>

int binarySearch(int arr[], int left, int right, int find)
{
   if (right >= left)
   {
        int mid = left + (right - left)/2;
 
        if (arr[mid] == find)  return mid;
 
        if (arr[mid] > find) return binarySearch(arr, left, mid-1, find);
 
        return binarySearch(arr, mid+1, right, find);
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
