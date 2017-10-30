import java.util.*;  

public class factorial{

    public static int fact(int i) {

        if(i==1||i==0){
        
            return 1;

        }

        else{

            return i * fact(i-1);


        }

    }


    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        
        System.out.println(fact(a));


    }

}
