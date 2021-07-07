// C# Program to find n'th  
// fibonacci Number with  
// O(Log n) arithmetic operations 
using System; 
  
class GFG 
{ 
  
static int MAX = 1000; 
static int[] f; 
  
public static int fib(int n) 
{ 
    if (n == 0) 
        return 0; 
          
    if (n == 1 || n == 2) 
        return (f[n] = 1); 
  
    if (f[n] != 0) 
        return f[n]; 
  
    int k = (n & 1) == 1 ? (n + 1) / 2 
                         : n / 2; 
  
    f[n] = (n & 1) == 1 ? (fib(k) * fib(k) +  
                           fib(k - 1) * fib(k - 1)) 
                        : (2 * fib(k - 1) + fib(k)) *  
                                            fib(k); 
  
    return f[n]; 
} 

static void Main()  
{ 
    int n = 9; 
    f = new int[MAX]; 
    Console.WriteLine(fib(n)); 
} 
}
