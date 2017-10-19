#include <iostream>

/* Function declaration */
int getNthValue(int n);

/* Program starts here */
int main()
{
    int nth; // the Nth number
    std::cout << "Enter the number of term to be printed: " << std::endl;

    std::cin >> nth;
    std::cout << getNthValue(nth) << std::endl;
    
}

/* Function definition */
int getNthValue(int n)
{
    /* Initial values */
    int a = 1;
    int b = 0;
    int c;
    
    /* Calculate the sequence untill the Nth number */
    for (int i = 0; i <n; i++)
    {
        c = a + b;        
        a = b;
        b = c;
    }
    return c; // return the desired number 
}