public class greater{
public static void main(String[] args){
        try{
        if(args.length!=2){
                System.out.println("You have to type in just 2 Numbers.");
        }
        else{
                if(Integer.parseInt(args[0])>Integer.parseInt(args[1]))
                {
                        System.out.println(args[0] + " is greater then " + args[1]);
                }
                else{
                        System.out.println(args[1] + " is greater then " + args[0]);
                }
        }
        }
        catch(NumberFormatException e)
        {
                System.out.println("You have to type in 2 >Numbers<");
        }
}
}
