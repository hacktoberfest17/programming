// Bubble Sort in C++
#include <iostream>
using namespace std;

int main() {

     int array[] = {10, 6, 56, 45, 37, 7, 23};    // Array to sort
     int size = sizeof(array) / sizeof(array[0]);

     while (true) {
          bool sorted = true;
          for (int i = 0; i < size; i++) {
               if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
               }
          }
          if (sorted) break;
     }

     // Printing sorted array
     for (int i = 0; i < size; i++)
          cout << array[i] << " ";

     return 0;
}
