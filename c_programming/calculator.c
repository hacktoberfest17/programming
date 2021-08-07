#include <stdio.h>


void main(){

//declarations
double num1, num2;
char op;

// This comand will write on the prompt
printf("Enter the calculation:\n");
// With this comand you will read a double, char and another double. In this order.
scanf("%lf%c%lf", &num1,&op,&num2);

// Switch case will test the char value the user wrote and choose the case equivalent
switch(op){
    case '+':
        printf("=%lf\n", num1+num2);
        break;
    case '-':
        printf("=%lf\n", num1-num2);
        break;
    case '*':
        printf("=%lf\n", num1*num2);
        break;
    case '/':
        if(num2==0){
            printf("Division by zero error!\n");
        }else{
            printf("=%lf\n", num1/num2);
        }
        break;
    case '%':
        printf("=%l\n", (long)num1%(long)num2);
        break;
    default: printf("Invalid Operator\n");
}

}



