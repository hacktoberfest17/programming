#include <stdio.h>


void main(){

//declarations
double num1, num2;
int i;

printf("Enter your choice \n 1 for + \n 2 for - \n 3 for * \n 4 for / \n 5 for %");
scanf("%d",&i)
printf("Enter two numbers")
scanf("%lf%lf", &num1,&num2);

switch(i){
    case 1:
        printf("=%lf\n", num1+num2);
        break;
    case 2:
        printf("=%lf\n", num1-num2);
        break;
    case 3:
        printf("=%lf\n", num1*num2);
        break;
    case 4:
        if(num2==0)
            printf("Division by zero error!\n");
        else
            printf("=%lf\n", num1/num2);
        
        break;
    case 5:
        printf("=%l\n", (long)num1%(long)num2);
        break;
    default: printf("Invalid Operator\n");
}

}



