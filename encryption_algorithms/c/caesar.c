#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define ONLY_ALPHABET

char* caesar_cipher(char* string, unsigned long len, int rot) {
    rot %= 26;
    if (rot < 0)
        rot += 26;

    char* result = calloc(len + 1, sizeof(char));
    unsigned long i;
    for (i = 0; i < len; i++) {
        #ifdef ONLY_ALPHABET
            char c = string[i];
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                int r = c >= 'a' && c <= 'z' ? 'a' : 'A';
                c = r + (c - r + rot) % 26;
            }
            result[i] = c;
        #else
            result[i] = (string[i] + rot) % 256;
        #endif
    }
    result[len] = 0;
    return result;
}

char* caesar_encode(char* string, unsigned long len, int rot) {
    return caesar_cipher(string, len, rot);
}

char* caesar_decode(char* string, unsigned long len, int rot) {
    return caesar_cipher(string, len, -rot);
}

int main(int argc, char* argv[]) {
    int shift;
    size_t len;
    char* s = NULL;
    
    printf("Enter message to encode: ");

    ssize_t n = getline(&s, &len, stdin);
    if (n < 0) {
        return EXIT_SUCCESS;
    }

    printf("Enter shift amount: ");
    scanf("%d", &shift);

    char* encoded = caesar_encode(s, n, shift);
    printf("Encoded: %s", encoded);

    char* decoded = caesar_decode(encoded, n, shift);
    printf("Decoded: %s", decoded);

    free(s);
    free(encoded);
    free(decoded);
    return EXIT_SUCCESS;
}
