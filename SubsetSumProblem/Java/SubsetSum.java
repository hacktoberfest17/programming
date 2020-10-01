import java.util.Scanner;

/* A Dynamic Programming solution for subset,
This code solves the problem in 
Pseudo-polynomial time use the Dynamic programming.


*/
class SubsetSUm { 
  
   
    static boolean isSubsetSum(int set[], 
                               int n, int sum) 
    { 
      
        boolean subset[][] = new boolean[sum + 1][n + 1]; 
  
        for (int i = 0; i <= n; i++) 
            subset[0][i] = true; 
  
    
        for (int i = 1; i <= sum; i++) 
            subset[i][0] = false; 
  
    
        for (int i = 1; i <= sum; i++) { 
            for (int j = 1; j <= n; j++) { 
                subset[i][j] = subset[i][j - 1]; 
                if (i >= set[j - 1]) 
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1]; 
            } 
        } 
  
        return subset[sum][n]; 
    } 
  
    /* Driver code */
    public static void main(String args[]) 
    { Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of your array:");
        int n = sc.nextInt(); 

        int set[] = new int [n];
        
        System.out.println("Enter your array:");
        for (int i = 0; i < n; i++)
         set[i] =sc.nextInt(); 

        System.out.println("Enter the sum:");
        int sum = sc.nextInt(); 
        
        if (isSubsetSum(set, n, sum) == true) 
            System.out.println("Found a subset"
                               + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum"); 

         sc.close();                   
    } 
} 
  