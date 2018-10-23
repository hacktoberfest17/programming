#include <iostream>
#include <stdio.h>      /* printf, scanf, puts, NULL */
#include <stdlib.h>     /* srand, rand */
#include <ctime>

bool sorted(int arr[], int size){
    for (int i = 1; i < size; i++) {
        if (arr[i] < arr[i - 1]) {
            return false;
        }
    }
    return true;
}

void bogoSort(int arr[], int size) {

    // Keep trying until sorted.
    while (!sorted(arr, size)) {
        srand(time(NULL));
        int x = rand() % size;
        int y = rand() % size;

        // Swap array positions.
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
int main(){

    int size = 6;
    int arr[] = {3, 2, 1, 5, 4, 6};
    int beginTime = time(NULL);
    std::cout << "Beginning bogo sort..." << std::endl;

    bogoSort(arr, size);

    // List is now sorted
    int endTime = time(NULL);
    int diff = endTime - beginTime;
    std::cout << "Finished in " << diff << " seconds" << std::endl;

    // Print out sorted list
    for (int i = 0; i < size; i++){
        std::cout << arr[i] << " ";
    }
    return 0;
}