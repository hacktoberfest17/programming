public class arraymaxrnd{
public static void main(String[] args){
        try{
                if(args.length!=1){
                        System.out.println("You have to type in a positive length for the array (INT Number)");
                }
                else{
                        //Set Up Array for Length given
                        int[] arrayMax = new int[Integer.parseInt(args[0])];
                        fillMe(arrayMax);
                        int max = getMax(arrayMax);
                        System.out.println("Maximum from random generated array is: " + max);
                }
        }
        catch(NumberFormatException e){
                System.out.println("You have to type in a positive length for the array (INT Number)");
        }
        catch(NegativeArraySizeException e){
                System.out.println("You have to type in a positive length for the array (INT Number)");
        }
}
public static void fillMe(int[] array) //Fills an array with random numbers
{
        java.util.Random numberGenerator = new java.util.Random();
        for(int i = 0; i < array.length; i++)
        {
                array[i] = numberGenerator.nextInt();
        }
}
public static int getMax(int[] array)
{
        int max = 0;
        for (int i=0; i<array.length; i++)
        {
                if(array[i]>max)
                {
                        max=array[i];
                }
        }
        return max;
}
}
