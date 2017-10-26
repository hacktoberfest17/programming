#include < iostream >
using namespace std;
#define max 1000
int enter(int a[max],int n)
{
      for( int i=0;i<n;i++)
     {
           cin>>a[i];
      } 
      return 0;
}
 
int display(  int a [max],int n)
{
      for( int i=0;i<n;i++)
     {
         cout<<a[i]<<"  ";
     }
     return 0;
}

int S_sort( int a[max] , int n)
{
     for( int i=0;i<n-1;i++)
      {
         int p=i;

      for( int j=i+1;j<n;j++)
      {
        if(a[j]<a[p])
        p=j;
      }
      if(p!=i)
      {
       int t=a[p];
       a[p]=a[i];
       a[i]=t;
      }
    }
    return 0;
}

int main()
{   int n;
    cout<<"Enter the size of the array: ";
    cin>>n;
    int a[max];
    cout<<"Enter the contents of the array....";
    enter (a,n);
    S_sort(a,n);
    cout<<"\nThe sorted array is....";
    display(a,n);
    cout<<endl;
    return 0;
}