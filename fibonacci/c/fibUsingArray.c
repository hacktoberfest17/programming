#include<stdio.h>

int main() {
    int n, i;
    printf("Enter total number of terms: ");
    scanf("%d", &n);
    char ch;
    while((ch = getchar()) != '\n' && ch != EOF);
    int f[n];
    f[0] = 0, f[1] = 1;
    for(i=2; i<n; i++)
        f[i] = f[i-1] + f[i-2];
    printf("Last term: %d", f[n-1]);
}