#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct book {
    int id;
    char name[100];
    char author[100];
    int status; // 0: available, 1: issued
} book;

book books[100];
int num_books = 0;

void add_book() {
    book new_book;

    printf("Enter book ID: ");
    scanf("%d", &new_book.id);

    printf("Enter book name: ");
    scanf("%s", new_book.name);

    printf("Enter book author: ");
    scanf("%s", new_book.author);

    new_book.status = 0;

    books[num_books++] = new_book;
}

void list_books() {
    printf("\nList of books:\n");
    for (int i = 0; i < num_books; i++) {
        printf("%d. %s by %s\n", books[i].id, books[i].name, books[i].author);
    }
}

void issue_book() {
    int book_id;
    int member_id;

    printf("Enter book ID: ");
    scanf("%d", &book_id);

    printf("Enter member ID: ");
    scanf("%d", &member_id);

    int book_index = -1;
    for (int i = 0; i < num_books; i++) {
        if (books[i].id == book_id) {
            book_index = i;
            break;
        }
    }

    if (book_index == -1) {
        printf("Book not found.\n");
    } else if (books[book_index].status == 1) {
        printf("Book is already issued.\n");
    } else {
        books[book_index].status = 1;
        printf("Book issued successfully.\n");
    }
}

void return_book() {
    int book_id;

    printf("Enter book ID: ");
    scanf("%d", &book_id);

    int book_index = -1;
    for (int i = 0; i < num_books; i++) {
        if (books[i].id == book_id) {
            book_index = i;
            break;
        }
    }

    if (book_index == -1) {
        printf("Book not found.\n");
    } else if (books[book_index].status == 0) {
        printf("Book is already returned.\n");
    } else {
        books[book_index].status = 0;
        printf("Book returned successfully.\n");
    }
}

int main() {
    int choice;

    do {
        printf("\nLibrary Management System\n");
        printf("1. Add book\n");
        printf("2. List books\n");
        printf("3. Issue book\n");
        printf("4. Return book\n");
        printf("5. Exit\n");

        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                add_book();
                break;
            case 2:
                list_books();
                break;
            case 3:
                issue_book();
                break;
            case 4:
                return_book();
                break;
            case 5:
                exit(0);
                break;
            default:
                printf("Invalid choice.\n");
        }
    } while (choice != 5);

    return 0;
}