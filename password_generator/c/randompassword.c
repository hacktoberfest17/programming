#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int counter = 0;
    srandom(time(NULL));  // Correct seeding function for random()
    char randChar;

    int  passwordLength;

    printf("Type in a password Length \n");
    scanf("%d", &passwordLength);

    while(counter < passwordLength)
    {
        randChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"[random () % 62];
        printf("%c", randChar);
        counter++;
    }
    printf("\n"); // Stops the output from being on the same line as the prompt
    return 0;
}
