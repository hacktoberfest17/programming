#include <iostream>

using namespace std;

int main(){
  float array[size];
for (int i=0; i < size; i++){
   array[i] = dataset[i];
}
for (int n=0; n<size-1; n++)
{
  for (int k=0; k<size-n-1; k++)
  {
    if (array[k]>array[k+1])
    {
      float temp = array[k+1];
      array[k+1] = array[k];

      array[k] = temp;
    }
    return 0;
}
