#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define bool char
#define TRUE 1
#define FALSE 0

typedef struct board {
    int n;
    int** matrix;
} BOARD;

void printStep(BOARD* b, int x, int y) {
    int i, j;
    for (i = 0; i < b->n; i++) {
        for (j = 0; j < b->n; j++) {
            if (i == x && j == y) {
                printf(" ");
            } else {
                if (b->matrix[i][j]) {
                    printf(" ");
                } else {
                    printf(" ");
                }
            }
        }
        printf("\n");
    }
    printf("\n\n");
}

bool isValid(BOARD* b, int x, int y) {

    int i, j;
    // check horizontal
    for (i = 0; i < b->n; i++) {
        if (i != y && b->matrix[x][i] == 1) return FALSE;
    }

    // check vertical
    for (i = 0; i < b->n; i++) {
        if (i != x && b->matrix[i][y] == 1) return FALSE;
    }
    // check diagonals
    // check top left
    i = x;
    j = y;
    while (i >= 0 && j >= 0) {
        if (i != x && j != y && b->matrix[i][j] == 1) {
            return FALSE;
        }
        i--;
        j--;
    }
    // check top right
    i = x;
    j = y;
    while (i >= 0 && j < b->n) {
        if (i != x && j != y && b->matrix[i][j] == 1) {
            return FALSE;
        }
        i--;
        j++;
    }
    // check bottom left
    i = x;
    j = y;
    while (i < b->n && j >= 0) {
        if (i != x && j != y && b->matrix[i][j] == 1) {
            return FALSE;
        }
        i++;
        j--;
    }
    // check bottom right
    i = x;
    j = y;
    while (i < b->n && j < b->n) {
        if (i != x && j != y && b->matrix[i][j] == 1) {
            return FALSE;
        }
        i++;
        j++;
    }
    return TRUE;
}

bool placeQueen(BOARD** b, int line, long int* calls) {
    int i;
    if (line >= (*b)->n) return TRUE;
    for (i = 0; i < (*b)->n; i++) {
        (*b)->matrix[line][i] = 1;
        (*calls)++;
        if (isValid((*b), line, i) && placeQueen(b, line+1, calls)) {
            return TRUE;
        }
        (*b)->matrix[line][i] = 0;
    }
    return FALSE;
}

void printBoard(BOARD* b) {
    int i, j;
    for (i = 0; i < b->n; i++) {
        for (j = 0; j < b->n; j++) {
            if (b->matrix[i][j]) {
                printf(" ");
            } else {
                printf(" ");
            }
        }
        printf("\n");
    }
}

void queens(int n) {
    // benchmarking
    clock_t start_t, end_t;
    float delta_t = 0.0;
    long int calls = 0;
    int i, j;
    BOARD* b = (BOARD*)malloc(sizeof(BOARD));
    b->n = n;
    b->matrix = (int**)malloc(sizeof(int*) * n);
    for (i = 0; i < n; i++) {
        b->matrix[i] = (int*)malloc(sizeof(int) * n);
        for (j = 0; j < n; j++) {
            b->matrix[i][j] = 0;
        }
    }

    start_t = clock();
    if (placeQueen(&b, 0, &calls)) {
        end_t = clock();
        // human readable time
        delta_t = ((float)(end_t - start_t) / 1000000000000.0F ) * CLOCKS_PER_SEC;
        printBoard(b);
        printf("%d,%ld,%lfs\n", n, calls, delta_t);
    }

    for (i = 0; i < n; i++) {
        free(b->matrix[i]);
        b->matrix[i] = NULL;
    }
    free(b->matrix);
    b->matrix = NULL;
    free(b);
}

int main(int argc, char const *argv[]) {
    system("clear");
    int i;
    int n = 0;
    scanf("%d", &n);
    printf("board size,calls,time\n");
    for (i = 0; i <= n; i++) {
        queens(i);
    }

    return 0;
}
