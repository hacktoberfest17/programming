public static int[] oddevenSort(int[] array) {
     boolean sorted = false;
     while (!sorted) {
          sorted = true;
          for (int i = 1; i < array.length - 1; i += 2) {
               if (array[ i ] > array[ i + 1 ]) {
                    swapKeys( array , i , i + 1 );
                    sorted = false;
               }
          }
          for (int i = 0; i < array.length - 1; i += 2) {
               if (array[ i ] > array[ i + 1 ]) {
                    swapKeys( array , i , i + 1 );
                    sorted = false;
               }
          }
     }

     return array;
}

public static void swapKeys(int[] array, int i, int j) {
     int temp;
     temp = array[ i ];
     array[ i ] = array[ j ];
     array[ j ] = temp;
}
