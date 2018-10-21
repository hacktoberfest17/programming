#include <stdio.h>


void main(){

//declarations
double num1, num2;
char op;

printf("Enter the calculation:\n");
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
        printf("=%l\n", (long)num1%(long)num2);
        break;
    default: printf("Invalid Operator\n");
}

}


##  Half pyramid alphabets programming 



#include <stdio.h>
int main()
{
    int i, j;
    char input, alphabet = 'A';

    printf("Enter the uppercase character you want to print in last row: ");
    scanf("%c",&input);

    for(i=1; i <= (input-'A'+1); ++i)
    {
        for(j=1;j<=i;++j)
        {
            printf("%c", alphabet);
        }
        ++alphabet;

        printf("\n");
    }
    return 0;
}




