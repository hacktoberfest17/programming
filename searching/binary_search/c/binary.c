#include<stdio.h>
// Program 5: To search for the presence of a given number in the array by Binary Search. 
//Worst Case complexity: O(logN)), where N is the size of the array.
//Prerequisite: The array should be sorted.

const int max=1000;
int enter(int a[max],int n)
{
      for( int i=0;i<n;i++)
     {
           scanf("%d",&a[i]);
      } 
      return 0;
}
 
int B_search( int a[max], int n, int d)
{
      int l=0,u=n-1,mid,f=0;
      while (l<=u && !f)
      {
        mid=(l+u)/2;
        if(a[mid] == d)
        {
            f++;
            break;
        }
        if(a[mid]>d)//lower(left) half of the array.
          u=mid-1;
        else if(a[mid]<d)//upper(right) half of the array.
          l=mid+1;
        //else f++;
       }
      if (f!=0)  
       { printf("\nFound at %d position", mid+1);
        printf("\n"); 
       }
      else printf("\nNot found \n");
      return 0;

}

int main()
{   int n,d;
    printf("Enter the size of the array: ");
    scanf("%d", &n);
    int a[max];
    printf("Enter the contents of the array in ascending order....");
    enter (a,n);
    printf("Enter the number to be searched: ");
    scanf("%d", &d);
    B_search(a,n,d);
    return 0;
}
/* 
Developed By  : Jap Leen Kaur Jolly

OUTPUT:
Enter the size of the array: 4
Enter the contents of the array in ascending order....3 4 5 2
Enter the number to be searched: 1

Not Found 
*/


