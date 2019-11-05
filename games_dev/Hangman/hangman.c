/**
 * File: hangman.c
 * Description: Classic hangman console game in C
 * Author: nicktheway (https://github.com/nicktheway)
 * Made for hacktoberfest17 on 22/10/2017
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

/**
 * The hangman function draws the state of the hangman based
 * on the number n, which represents the mistakes.
 */
void hangman(int n) {
    char head, hand1, hand2, body, leg1, leg2;
    head = hand1 = hand2 = body = leg1 = leg2 = ' ';
    switch (n){
        case 6: leg2 = '\\';
        case 5: leg1 = '/';
        case 4: hand2 = '\\';
        case 3: hand1 = '/';
        case 2: body = '|';
        case 1: head = 'O';
        default:
        {
            printf("++----\n|    |\n|    %c\n|   %c%c%c\n|    %c\n|   %c %c\n|\n", head, hand1, body, hand2, body, leg1, leg2);
        }
    }
}

int main(void){
    int i, j, n, flag, fl_used, wordLength;
    char word[21], *visibleWord, letter, usedLetters[10];
    
    //Prompte one user to enter a word.
    printf("Enter the secret word: ");
    scanf("%s", word);
    
    //Initialize variables
    wordLength = strlen(word);
    n = j = 0;
    visibleWord = (char *) malloc((wordLength + 1) * sizeof(char));
    for (i = 0; i < wordLength; i++){
        visibleWord[i] = '*';
    }
    visibleWord[wordLength] = '\0';
    
    //Game loop
    while(1){
        for (i = 0; i < 25; i++) printf("\n");
        hangman(n);
        //Checks if the player lost
        if (n == 6){
            flag = 0;
            break;
        }
        //Checks if the player won
        if (!strcmp(word, visibleWord)){
            flag = 1;
            break;
        }
        
        flag  = 0;
        printf("\nHidden word: %s\n", visibleWord);
        printf("Guess a letter: ");
        while (1){
            scanf("%c", &letter);
            if (letter == ' ' || letter == '\n') continue;
            if (!isalpha(letter)){
                printf("That isn't a letter, try again: ");
                continue;
            }
            else break;
        }
        for (i = 0; i < wordLength; i++){
            if (letter == word[i] || letter == word[i] + ('a'-'A') || letter == word[i] - ('a'-'A')){
                visibleWord[i] = word[i];
                flag = 1;
            }
        }
        
        for (fl_used = 0, i = 0; i < j; i++){
            if (letter == usedLetters[i] || letter == usedLetters[i] + ('a'-'A') || letter == usedLetters[i] - ('a'-'A')){
                fl_used = 1;
            }
        }
        if (fl_used){
            printf("That letter has already been used, try again: \n");
            continue;
        }
        if (!flag){
            printf("Wrong...\n");
            n++;
        }
        else printf("Bravo!\n");
        usedLetters[j++] = letter;
    }
    if (flag){
        printf("Congratulations you guessed the secret world: %s\n", word);
    }
    else{
        printf("You lost...\nThe secret word was: %s\n", word);
    }
    return 0;
}
