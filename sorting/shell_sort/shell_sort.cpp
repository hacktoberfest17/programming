#include<bits/stdc++.h>
using namespace std;

void shell_sort(long int arr[],long int size){
        long int incr,cur,temp,var;
        for(incr=(size-1)/2;incr>0;incr/=2)
        {
            for (cur = incr; cur <size; cur++)
            {
                var=arr[cur];                
                for(temp=cur-incr;temp>=0&&var<arr[temp];temp-=incr)
                {
                    arr[temp+incr]=arr[temp];
                }
                arr[temp+incr]=var;
            }
        }
}


int main(){
  
  long int arr[10];
  cout<<"Enter elements in array:";
  
  for(int i=0;i<10;i++)
    cin>>arr[i];  

  shell_sort(arr,10);
  cout<<"\nSorted Array:\n";
  for(int i=0;i<10;i++)
    cout<<arr[i]<<" ";
    
  return 0;
}
