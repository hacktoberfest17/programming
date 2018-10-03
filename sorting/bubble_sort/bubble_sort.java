public static int [] bubbleSort(int [] array){
    for (int x=0; x<array.length; x++) {
        for(int y=x+1; y<array.length; y++) {
            if(array[x]>array[y]) {
                int temp = array[x];
                array[x] = array[y];
                array[y] = temp;
            }
        }
    }
    return array;
}
