#include<iostream>
#include<climits>
#include<cmath>
#include<ctime>
#include<cstdlib>
void merge(int arr[],int p,int q,int r){
  int n1=q-p+1;
  int n2=r-q;
  int L[(n1+1)];
  int R[(n2+1)];
  for(int i=0;i<n1;i++){
    L[i]=arr[p+i];
  }
  for(int i=0;i<n2;i++){
    R[i]=arr[i+q+1];
  }
  L[n1]=INT_MAX;
  R[n2]=INT_MAX;
  int i=0,j=0;
  for(int k=p;k<=r;k++){
    if(L[i]<=R[j]){
      arr[k]=L[i];
      i++;
  }
  else{
    arr[k]=R[j];
    j++;
}
  }
}
void mergesort(int arr[],int p,int r){
  if(p<r){
  int q=(p+r)/2;
  mergesort(arr,p,q);
  mergesort(arr,q+1,r);
  merge(arr,p,q,r);
}
}
int partition(int arr[],int p,int q){
int k=p;
for(int i=p+1;i<=q;i++){
  if(arr[i]<arr[p]){
    k++;
    int temp=arr[k];
    arr[k]=arr[i];
    arr[i]=temp;
  }
}
int temp=arr[p];
arr[p]=arr[k];
arr[k]=temp;
return k;
  }
void quicksort(int arr[],int p,int q){
  if(p<q){
  int k=partition(arr,p,q);
  quicksort(arr,p,k-1);
  quicksort(arr,k+1,q);
  }
}
void max_heapify(int arr[],int n, int i){
  int lchild=2*i+1;
  int rchild=2*i+2;
  int largest;
  if(lchild<n && arr[lchild]>=arr[i]){
    largest=lchild;
  }
  else {largest=i;}
  if(rchild<n && arr[rchild]>=arr[largest]) {largest=rchild;}
  if(largest!=i){
    int temp=arr[i];
    arr[i]=arr[largest];
    arr[largest]=temp;
    max_heapify(arr,n,largest);
  }
}
void build_max_heap(int arr[], int n){
  int x=floor(n/2)-1;
  for(int i=x;i>=0;i--){
    max_heapify(arr,n,i);
  }
}
void heapsort(int arr[],int n){
  build_max_heap(arr,n);
  int m=n;
  while(m-1){
    int temp=arr[0];
    arr[0]=arr[m-1];
    arr[m-1]=temp;
    m--;
    max_heapify(arr,m,0);
  }
}
void insertion(int arr[],int n){
  int key=0,j=0;
  for(int i=1;i<n;i++){
    key=arr[i];
    j=i-1;
    while(j>=0 && arr[j]>key){
      arr[j+1]=arr[j];
      j=j-1;
    }
    arr[j+1]=key;
  }
}
void bubble(int arr[],int n){
  bool isswap;
  for(int i=0;i<n-1;i++){
    isswap=0;
    for(int j=0;j<n-i-1;j++){
      if(arr[j]>arr[j+1]) {
        int temp=arr[j];
        arr[j]=arr[j+1];
        arr[j+1]=temp;
        isswap=1;
      }
    }
    if(isswap=0) break;
  }
}
using namespace std;
int main(){
  int n;
  cin>>n;
  int arr[n],inarr[n];
  for(int i=0;i<n;i++){
    int rd=rand() % (INT_MAX);
    arr[i]=rd;
    inarr[i]=rd;
  }
cout<<endl;
time_t tstart;
time_t tend;
tstart=clock();
mergesort(arr,0,n-1);
tend=clock();
// cout<<"The sorted array is ";
// for(int i=0;i<n;i++){
//     cout<<arr[i]<<" ";
//   }
// cout<<endl;
cout<<"The execution time for merge sort is "<<(double)(tend-tstart)<<" microseconds"<<endl;
cout<<endl;
for(int i=0;i<n;i++){
arr[i]=inarr[i];
}
tstart=clock();
quicksort(arr,0,n-1);
tend=clock();
// cout<<"The sorted array is ";
// for(int i=0;i<n;i++){
//     cout<<arr[i]<<" ";
//   }
//   cout<<endl;
  cout<<"The execution time for quick sort is "<<(double)(tend-tstart)<<" microseconds"<<endl;
  cout<<endl;

for(int i=0;i<n;i++){
  arr[i]=inarr[i];
    }
  tstart=clock();
  heapsort(arr,n);
  tend=clock();
//   cout<<"The sorted array is ";
// for(int i=0;i<n;i++){
//     cout<<arr[i]<<" ";
//     }
//   cout<<endl;
  cout<<"The execution time for heap sort is "<<(double)(tend-tstart)<<" microseconds"<<endl;
  cout<<endl;

for(int i=0;i<n;i++){
  arr[i]=inarr[i];
    }
  tstart=clock();
  bubble(arr,n);
  tend=clock();
  // cout<<"The sorted array is ";
  // for(int i=0;i<n;i++){
  //     cout<<arr[i]<<" ";
  //     }
  // cout<<endl;
  cout<<"The execution time for bubble sort is "<<(double)(tend-tstart)<<" microseconds"<<endl;
  cout<<endl;

  for(int i=0;i<n;i++){
      arr[i]=inarr[i];
        }
  tstart=clock();
  insertion(arr,n);
  tend=clock();
  // cout<<"The sorted array is ";
  // for(int i=0;i<n;i++){
  //     cout<<arr[i]<<" ";
  //   }
  //   cout<<endl;
    cout<<"The execution time for insertion sort is "<<(double)(tend-tstart)<<" microseconds"<<endl;
      cout<<endl;
return 0;
    }
