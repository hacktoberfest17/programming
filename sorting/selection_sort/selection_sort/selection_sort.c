	
#include<stdio.h>
 
  //finds the smallest number in arr in between k to n (both inclusive)
int smallest(int arr[], int k, int n)
{
    int pos=k, small=arr[k],i;
    for(i=k+1;i<n;i++)
    {
        if(arr[i]<small)
        {
            small=arr[i];
            pos=i;
        }
    }
    return pos;
}
 
void selection_sort(int arr[], int n)
{
    int k,pos,temp;
    for(k=0;k<n;k++)
    {
        pos=smallest(arr,k,n);
        temp=arr[k];
        arr[k]=arr[pos];
        arr[pos]=temp;
    }
}
 
int main ()
{
    int ch,a[20],n,i;
    printf("Enter the size of array\n");
    scanf("%d",&n);
    printf("Enter the elements of the array:\n");
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    selection_sort(a,n);
    printf("Sorted Array is \n");
    for(i=0;i<n;i++)
        printf("%d\n",a[i]);
    return 0;
}
