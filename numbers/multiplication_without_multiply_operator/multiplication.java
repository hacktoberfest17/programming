import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;  

class Multiplier{

    public int multiplyByTen(int num)
    {

        return (num<<1) + (num<<3);
    
    }

}

/**
 * Demo
 *
 */
class multiplication {

    public static void main(String[] args) throws IOException{
        
        //Initializing input stream
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        
        //Reading input from input stream
        int num = Integer.parseInt(br.readLine());
        Multiplier multiplier = new Multiplier();
        System.out.println(num+" * 10 = "+multiplier.multiplyByTen(num));
    }
}