public class selection_sort {
     public static void main(String[] args) {

          int[] array = {1, 89, 56, 72, 34, 7, 12, 66};     // Array to sort

          for (int i = 0; i < array.length; i++) {
               int minIndex = i;
               for (int j = i + 1 ; j < array.length; j++) {
                    if (array[j] < array[minIndex])
                         minIndex = j;
               }
               int temp = array[i];
               array[i] = array[minIndex];
               array[minIndex] = temp;
          }

          for (int arr : array)
               System.out.print(arr + " ");
     }
}
