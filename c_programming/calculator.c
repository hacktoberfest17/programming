#include <stdio.h>


void main(){

//declarations
double num1, num2;
char op;

printf("Enter the calculation:\n");
scanf("%lf%c%lf", &num1,&op,&num2);

switch(op){
    case '+':
        printf("Result of your Equation is=%lf\n", num1+num2);
        break;
    case '-':
        printf("Result of your Equation is=%lf\n", num1-num2);
        break;
    case '*':
        printf("Result of your Equation is=%lf\n", num1*num2);
        break;
    case '/':
        if(num2==0){
            printf("Division by zero error!\n");
        }
        else{
            printf("Result of your Equation is=%lf\n", num1/num2);
        }
        break;
    case '%':
        printf("Result of your Equation is=%l\n", (long)num1%(long)num2);
        break;
    default: printf("Invalid Operator. Try a valid operator\n");
}

}



