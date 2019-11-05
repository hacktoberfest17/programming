#include<iostream>
#include<string>
#include<ctime>
#include<iomanip>
#include<random>
using namespace std;

void input(int [], int);
int binarySearch(int [], int, int, int);
void insertionSort(int [], int);
void bubbleSort(int [], int);
void swap(int*, int*);
void selectionSort(int [], int);
void time_it(double, double, string);
void modified_bubbleSort(int [], int);
void mergeSort(int [], int, int);
void merge(int [], int, int, int);
void cpu_clock_cycles(double, double);

int binarySearch(int a[], int low, int high, int x) {
    if (high <= low)
        return (x > a[low])?  (low + 1): low;
    int mid = (low + high)/2;
    if(x == a[mid])
        return mid+1;
    if(x > a[mid])
        return binarySearch(a, mid+1, high, x);
    return binarySearch(a, low, mid-1, x);
}

void insertionSort(int a[], int n) {
    int loc, i, j, selected;
    for(i=1; i<n; i++) {
        selected = a[i];
        j = i - 1;
        loc = binarySearch(a, 0, j, selected);
        while(j >= loc){
            a[j+1] = a[j];
            j--;
        }
        a[j+1] = selected;
    }
}

void bubbleSort(int b[], int n) {
    int i, j;
    for(i=n-1;i>=0;i--) {
        for(j=0; j<i; j++) {
            if(b[j+1] < b[j]) {
                swap(b+j,b+j+1);
            }
        }
    }
}

void swap(int*a, int*b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void selectionSort(int c[], int n) {
    int min, i, j;
    for(i=0; i<n-1; i++) {
        for(j=i+1; j<n; j++) {
            if(c[j] < c[i]){
                swap(c+i,c+j);
            }
        }
    }
}

void time_it(double strt, double lst, string str) {
    double time_taken = double(lst - strt)/ double(CLOCKS_PER_SEC);
    cout <<"Time taken by "<< str <<" Sort is: "<< fixed << time_taken << setprecision(3);
    cout <<" sec(s)\n";
}

void cpu_clock_cycles(double _2, double _1) {
    cout <<"CPU cycles taken: " << _1 - _2 << endl;
}

void input(int x[], int n) {
    int i;
    random_device random_device;
    mt19937 random_engine(random_device());
    for(i=0; i<n; i++) {
        uniform_int_distribution<int> distribution_1_1000(1, 1000);
        x[i] = distribution_1_1000(random_engine);
    }
}

void modified_bubbleSort(int b[], int n) {
    int i, j;
    bool swapped;
    for(i=n-1;i>=0;i--) {
        swapped = false;
        for(j=0; j<i; j++) {
            if(b[j+1] < b[j]) {
                swap(b+j,b+j+1);
                swapped = true;
            }
        }
        if(!swapped) break;
    }
}

void mergeSort(int a[], int lo, int hi) {
    int mid;
    if(lo < hi) {
        mid = (lo + hi)/2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);
        merge(a, lo, hi, mid);
    }
}

void merge(int a[], int l, int h, int m) {
    int i, j, k, temp[h-l+1];
    i = l;
    j = m + 1;
    k = 0;
    while(i <= m && j <= h) {
        if(a[i] < a[j])
            temp[k++] = a[i++];
        else
            temp[k++] = a[j++];
    }

    while(i <= m)
        temp[k++] = a[i++];

    while(j <= h)
        temp[k++] = a[j++];

    for(i=l, j=0; i<=h; i++, j++)
        a[i] = temp[j];

}

int main() {
    clock_t start, end;
    int size, elem, i;
    cout <<"Enter the size of the array\n";
    cin >> size;
    //Dynamic array allocation during runtime to minimize space complexity
    int*a = new int[size];
    int*b = new int[size];
    int*c = new int[size];
    int*d = new int[size];
    int*e = new int[size];
    cout <<"Filling random array elements\n";

    //Array gets automatically filled with random numbers
    input(a, size);
    for(i=0; i < size; i++)
        e[i] = d[i] = c[i] = b[i] = a[i];
    cout <<"Done\n";

    cout <<"\nSorting the array using Merge Sort...\n";
    start = clock();
    mergeSort(e, 0, size-1);
    end = clock();
    delete[] e;
    time_it(start, end, "Merge");
    cpu_clock_cycles(start, end);


    cout <<"\nSorting the array using Binary Insertion Sort...\n";
    start = clock();
    insertionSort(a, size);
    end = clock();
    delete[] a;
    //Time function calculates execution time for sorting
    time_it(start, end, "Binary Insertion");
    cpu_clock_cycles(start, end);

    cout <<"\nSorting the array using Selection Sort...\n";
    start = clock();
    selectionSort(c, size);
    end = clock();
    //Array memory is cleared after the array is no longer required
    delete[] c;
    time_it(start, end, "Selection");
    cpu_clock_cycles(start, end);


    cout <<"\nSorting the array using Bubble Sort...\n";
    start = clock();
    bubbleSort(b, size);
    end = clock();
    delete[] b;
    time_it(start, end, "Bubble");
    cpu_clock_cycles(start, end);

    cout <<"\nSorting the array using Modified Bubble Sort...\n";
    start = clock();
    modified_bubbleSort(d, size);
    end = clock();
    delete[] d;
    time_it(start, end, "Modified Bubble");
    cpu_clock_cycles(start, end);

    return 0;
}
