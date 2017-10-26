public static int [] bubbleSort(int [] array){
    int lastPosition = array.length;
    while(lastPosition > 0){
        int position = 1;
        while(position < lastPosition){
        	if(array[position] < array[position-1]){
                int temp = array[position];
                array[position] = array[position-1];
                array[position-1] = temp;
             }
                position++;
        }

            lastPosition--;
    }

    return array;
}
