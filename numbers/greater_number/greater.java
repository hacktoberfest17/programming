public class greater{
    public static void main(String[] args){
        try{
            if(args.length<=1){
                System.out.println("You have to type in 2 or more numbers.");
            }
            else{
                int greater = 0;
                for(int i=0; i<args.length; i++) {
                    int a = Integer.parseInt(args[i]);
                    if (a > greater)
                    {
                        greater = a;
                    }
                }
                System.out.println("The Greatest number is: " + greater);
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("You have to type in 2 or more >numbers<");
        }
    }
}
