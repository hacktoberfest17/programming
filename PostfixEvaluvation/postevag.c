#include <stdio.h>
  #include <stdlib.h>
  #include <string.h>

  struct node {
        int data;
        struct node *next;
  };

  struct node *top = NULL;



  int main() {
        char str[100];
        int i, data = -1, operand1, operand2, result,info;

        printf("Enter ur postfix expression:");
        fgets(str, 100, stdin);
        for (i = 0; i < strlen(str); i++) {
                if (isdigit(str[i])) {

                        data = (data == -1) ? 0 : data;
                        data = (data * 10) + (str[i] - 48);

                        continue;
                }


                if (data != -1) {
                        push(data);
                }

                if (str[i] == '+' || str[i] == '-'
                        || str[i] == '*' || str[i] == '/') {

                        operand2 = pop();
                        operand1 = pop();
                        if (operand1 == -1 || operand2 == -1)
                                break;
                        switch (str[i]) {
                                case '+':
                                        result = operand1 + operand2;
                                        push(result);
                                        break;
                                case '-':
                                        result = operand1 - operand2;
                                        push(result);
                                        break;
                                case '*':
                                        result = operand1 * operand2;
                                         push( info);

                                        push(result);
                                        break;
                                case '/':
                                        result = operand1 / operand2;
                                        push(result);
                                        break;
                        }
                }
                data = -1;
        }
        if (top != NULL && top->next == NULL)
                printf("Output:%d\n", top->data);
        else
                printf("u ve entered wrong expression\n");
        return 0;
  }
  void push(int info)
{
    struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node));
    temp->data=info;
    temp->next=NULL;
    if( temp == NULL)
        printf(" Out of Memory !! Overflow !!!");
    else
    {

        temp->next=top;
        top=temp;

    }
}

  int pop () {
        int data;
        struct node *temp;
        if (top == NULL)
                return -1;
        data = top->data;
        temp = top;
        top =  top->next;
        free(temp);
        return (data);
  }

