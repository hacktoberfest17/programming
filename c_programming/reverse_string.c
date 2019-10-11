#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
    char value1[128]; strcpy(value1, argv[1]);
    int len = strlen(value1);
    for(int i = len - 1; i >= 0; i--){
        printf("%c", value1[i]);
    }
}
