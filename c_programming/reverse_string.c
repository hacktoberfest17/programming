#include <stdlib.h>
#include <stdio.h>

char* reverse_string(char* in) {
    int i, j;
    char* out;

    for(i = 0; in[i] != '\0'; i++);

    out = (char*) malloc(sizeof(char) * (i + 1));
    out[i--] = '\0';
    for (j = 0; i >= 0; i--, j++) 
        out[j] = in[i];

    return out;
}

int main() {
    char name[] = {'M', 'A', 'R', 'C', 'U', 'S', '\0'};
    char* result = reverse_string(name);
    printf("Reverse of %s is %s\n", name, result);
    return 0;
}
