import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NthFibonacci {
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        System.out.println("Enter the number of term to be printed:");
        long n = Reader.nextLong();
        System.out.println(smartfib(n)[1][0]);
    }

    public static long[][] smartfib(long n){
        long a[][]=new long[2][2];
        a[0]= new long[]{1, 1};
        a[1]= new long[]{1,0};
        if (n==0){
            a[1][0]=0;
            return a;
        }
        if (n==1){
            return a;
        }
        if (n%2==1){
            return product(square(smartfib(((n-1)/2))),a);
        }
        return square(smartfib((n/2)));
    }
    public static long[][] square(long a[][]){
        long b[][]=new long[2][2];
        for (int i=0;i<2;i++){
            for (int j=0;j<2;j++){
                long sum=0;
                for(int k=0;k<2;k++){
                    sum+=(a[i][k]*a[k][j]);
                }
                b[i][j]=sum;
            }
        }
        return b;
    }
    public static long[][] product(long a[][],long b[][]){
        long c[][]=new long[2][2];
        for (int i=0;i<2;i++){
            for (int j=0;j<2;j++){
                long sum=0;
                for(int k=0;k<2;k++){
                    sum+=(a[i][k]*b[k][j]);
                }
                c[i][j]=sum;
            }
        }
        return c;
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}