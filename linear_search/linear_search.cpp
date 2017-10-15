// Linear Search in C++
#include <iostream>
using namespace std;

int main() {

     // Random data to search from
     int searchArray[] = {10, 23, 89, 126, 51, 7, 45, 55};
     int size = sizeof(searchArray) / sizeof(searchArray[0]);
     int search = 51;    // Number to search
     int index = -1;

     for (int i = 0; i < size; i++) {
          if (searchArray[i] == search) {
               index = i;
               break;
          }
     }

     if (index >= 0)
          cout << search << " found at index " << index << endl;
     else
          cout << search << " not found in the array" << endl;

     return 0;
}
