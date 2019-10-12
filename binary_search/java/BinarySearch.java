import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        System.out.println("Enter the number you wish to search in the array");
        int n = sc.nextInt();
        int position = binarySearch(a,n,0,a.length) + 1;
        System.out.println("Position of that element in the array is " + position);
    }

    private static int binarySearch(int[] a, int n, int start, int end) {
        int mid = (start+end) / 2;
        int index = mid;
        if(n > a[mid])
            index = binarySearch(a, n, mid, end);
        if(n < a[mid])
            index = binarySearch(a, n, start, mid);
        return index;
    }
}
