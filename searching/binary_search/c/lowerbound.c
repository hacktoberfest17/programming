/*Lower bound return the index of the searched element where it first occurs & if element doesnot occur then returns
  the positon of the higher element than it if exist ,i.e,in given example for 4,the value is 5,for 6 does not exist; 
        example- given 5 elements in increasing order 
            1 2 2 3 5
            lowerbound(2)=2;
            lowerbound(3)=4;
            lowerbound(6)=Does not exist;
            lowerbound(4)=5;
*/
#include <stdio.h>

int lower_bound(int a[], int n, int x) {
    int l = 0;
    int h = n; // Not n - 1
    while (l < h) {
        int mid = (l + h) / 2;
        if (x <= a[mid]) {
            h = mid;
        } else {
            l = mid + 1;
        }
    }
    return l;
}

int main()
{
    int n,i,a[100005],x;
    printf("Enter total number of elements in array (should be less than 100000)-\n");
    scanf("%d",&n);
    printf("Enter %d numbers in increasing sequence\n",n);
    for(i=0;i<n;i++)
        scanf("%d",&a[i]);
    printf("Enter the number for which lower bound is to be found=\n");
    scanf("%d",&x);

    int low=lower_bound(a,n,x);
    if(low+1>n)
        printf("Does not exist\n");
    else
        printf("Lower bound of %d is - %d\n",x,low+1);
    return 0;

}