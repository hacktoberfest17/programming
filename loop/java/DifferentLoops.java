import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Beven Lee
 */
public class DifferentLoops {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Looping using foreach loop");
        for(Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        System.out.println("Looping using for loop");
        for(int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();

        System.out.println("Looping using while loop");
        int i = 0;
        while(i < numbers.size()) {
            System.out.print(numbers.get(i) + " ");
            i++;
        }
        System.out.println();

        System.out.println("Looping using do while loop");
        i = 0;
        do {
            System.out.print(numbers.get(i) + " ");
            i++;
        }
        while(i < numbers.size());
        System.out.println();

        System.out.println("Looping using an iterator");
        Iterator<Integer> iterator = numbers.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.print(next + " ");
        }
        System.out.println();
        System.out.println("Very cool loops");
    }
}