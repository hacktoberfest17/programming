// Objective : get nth Fibonacci number
// Method    : matrix

class fibonacci_matrix {
    static int fib(int n) {
        int F[][] = new int[][]{{1,1},{1,0}};
        
        if (n == 0) return 0;
        power(F, n-1);
     
        return F[0][0];
    }
      
    // helper
    static void multiply(int F[][], int M[][]) {
        int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
        int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
        int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
        int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];
          
        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
 
    // helper
    static void power(int F[][], int n) {
        int i;
        int M[][] = new int[][]{{1,1},{1,0}};
     
        for (i = 2; i <= n; i++) {
            multiply(F, M);
        }
    }
      
    public static void main (String args[]) {
        int n = 9;
        System.out.println(fib(n));
    }
}