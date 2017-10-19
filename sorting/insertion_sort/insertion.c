#include<stdio.h>
//To sort the entered array by Insertion Sort Method.
const int max=1000;
int enter(int a[max],int n)
{
      for( int i=0;i<n;i++)
           scanf("%d",&a[i]);
      return 0;
}
 
int display(  int a [max],int n)
{
      for( int i=0;i<n;i++)
     {
         printf("%d",a[i]);
         printf("  ");
     }
     return 0;
}

int I_sort( int a[max] , int n)
{
    for( int i=1;i<n;i++)
          {  int j=i-1,t=a[i];
             while(a[j]>t&&j>=0)
              { a[j+1]=a[j];
                 j--;
              }
             a[j+1]=t;
          }
      


    return 0;
}

int main()
{   int n;
    printf("Enter the size of the array: ");
    scanf("%d", &n);
    int a[max];
    printf("Enter the contents of the array....");
    enter (a,n);
    I_sort(a,n);
    printf("\nThe sorted array is....");
    display(a,n);
    printf("\n");
    return 0;
}

