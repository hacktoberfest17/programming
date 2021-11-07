#include <stdio.h>

unsigned int ackermann(unsigned int m, unsigned int n) {
    if (m == 0) return n + 1;
    if (m > 0 && n == 0) return ackermann(m - 1, 1);
    return ackermann(m - 1, ackermann(m, n - 1));
}

int main() {
    printf("%d\n", ackermann(3,4));
    return 0;
}
