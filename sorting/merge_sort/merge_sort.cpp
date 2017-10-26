#include <bits/stdc++.h>

using namespace std;

int a[100005];
int n;

void Merge(int a[], int l, int m, int r) {
    int i1, i2, pos;
    int n1 = m - l + 1;
    int n2 = r - m;
    int L[n1], R[n2];

    for(int i = 0; i < n1; ++i)
        L[i] = a[l + i];
    for(int i = 0; i < n2; ++i)
        R[i] = a[m + 1 + i];

    i1 = i2 = 0; // index of array 1 and 2
    pos = l; // index of megred array
    while (i1 < n1 && i2 < n2) {
        if (L[i1] <= R[i2]) a[pos] = L[i1++];
        else a[pos] = R[i2++];
        ++pos;
    }
    while (i1 < n1) a[pos] = L[i1++], ++pos;
    while (i2 < n2) a[pos] = R[i2++], ++pos;
}

void MergeSort(int a[], int l, int r) {
    if (l < r) {
        int m = (l + r) / 2;

        //Sort 2 parts
        MergeSort(a, l, m);
        MergeSort(a, m + 1, r);
        Merge(a, l, m, r);
    }
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> n;
    for(int i = 1; i <= n; ++i) 
        cin >> a[i];

    MergeSort(a, 1, n);

    for(int i = 1; i <= n; ++i) 
        cout << a[i] << '\n';
    return 0;
}
