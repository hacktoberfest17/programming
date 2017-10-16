import java.util.Scanner;
public class BinarySearch {
    static int  array[]= {2,3,5,7,11,13,17,19,23,27,29};
    public static void main(String args[]){
        int startingIndex = 0;
        int lastIndex = array.length - 1;
        int middleIndex = (startingIndex + lastIndex)/2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value of a element in defined array :");
        int target=scanner.nextInt();
        int flag = 0;
        while(flag==0){
            if(lastIndex > startingIndex){
                middleIndex = (startingIndex + lastIndex)/2;
                if(array[middleIndex] == target){
                    System.out.println("The index of the element " + target+ " is " + middleIndex);
                    flag=1;
                }else if(array[middleIndex + 1] == target){
                    System.out.println("The index of the element " + target+ " is " +(middleIndex+1));
                    flag = 1;
                }else if(array[middleIndex] < target){
                    startingIndex = middleIndex + 1;
                }else if(array[middleIndex] > target){
                    lastIndex = middleIndex - 1;
                }
            }
            else{
                System.out.println("This value is not in the array as a element");
                flag = 1;
            }
        }
    }
}
