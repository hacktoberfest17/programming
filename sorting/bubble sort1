#include<iostream>
using namespace std;
int main(){

    int n;
    cout<<"Enter no of elements"<<endl;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }
    int counter=1;
    while(counter<n){
    for(int i=0;i<n-counter;i++)
    {
        if(arr[i]>arr[i+1])
        {
            int temp=arr[i+1];
            arr[i+1]=arr[i];
            arr[i]=temp;
        }
        
    }
    counter++;
    }

    for(int i=0;i<n;i++)
    {
        cout<<arr[i]<<" ";
    }

return 0;
}
