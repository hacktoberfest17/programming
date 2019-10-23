//Header Files
#include <stdio.h> 
#include <conio.h>

void main()
{
    //declarations
    double num1, num2;
    char op;

    printf("Enter the calculation:\n");
    scanf("%lf%c%lf", &num1, &op, &num2);

    switch(op)
    {
        case '+':                                     //Addition
            printf("%lf + %lf = %lf\n", num1, num2, num1 + num2);
            break;

        case '-':                                     //Subtraction
            printf("%lf - %lf = %lf\n", num1, num2, num1 - num2);
            break;

        case '*':                                     //Multiplication
            printf("%lf * %lf = %lf\n", num1, num2, num1 * num2);
            break;

        case '/':                                     //Quotient
            if(num2==0)
            {
                printf("Division by zero error!\n");  //Invalid case
            }
            else
            {
                printf("%lf / %lf = %lf\n", num1, num2, num1 / num2);
            }
            break;

        case '%':
            printf("%lf mod %lf = %l\n", num1, num2, (long)num1 % (long)num2);  //Modulus
            break;

        default: printf("Invalid Operator\n");         //Default Case : In case, no condition is satisfied then this case is executed.
    }
}



