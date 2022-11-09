#include <stdio.h>
#include <math.h>

int main(){

//declarations
double num1, num2;
char op;

printf("Enter the first number : operator: second number:\n");
scanf("%lf%c%lf", &num1,&op,&num2);

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
        printf("=%ld\n", (long)num1%(long)num2);
        break;
    default: printf("Invalid Operator\n");
}
 return 0;
}



