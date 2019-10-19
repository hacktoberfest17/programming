#include<stdio.h>
int a[20],n,i;
void heapify(int n)
{
    int i,k,v,j,heap;
    for(i=n/2;i>=1;i--)
    {
        k=i;
        v=a[k];
        heap=0;
        while((!heap) && (2*k)<=n)
        {
            j=2*k;
            if(j<n)
                if(a[j]<a[j+1])
                    j=j+1;
            if(v>=a[j])
                heap=1;
            else
            {
                a[k]=a[j];
                k=j;
            }
        }
       a[k]=v;
    }
}
void main()
{
    int t,size;
    printf("enter the size of the array\n");
    scanf("%d",&n);
    printf("enter the array\n");
    for(i=1;i<=n;i++)
        scanf("%d",&a[i]);
    heapify(n);
    for(i=n;i>=1;i--)
    {
        t=a[1];
        a[1]=a[i];
        a[i]=t;
        size=i-1;
        heapify(size);
    }
    for(i=1;i<=n;i++)
        printf("%d ",a[i]);

}
