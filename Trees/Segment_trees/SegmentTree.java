public class SegmentTree {

    private long tree[];
    private int length = 0;

    //build the tree with new array size: 2*2^(log2(n))-1
    public SegmentTree(long[] arr){
        length = arr.length-1;
        int x = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        tree = new long[max_size];
        buildTree(arr, 0, length, 0);
    }

    public long getSum(int start, int end){
        //input validation
        if(start<0 || end > length || end<start){
            System.out.println("Invalid Input");
            return -1;
        }
        return getSum(0,length,start,end,0);
    }

    //recursive walking and summing in the tree
    private long getSum(int segstart,int segend,int rangestart,int rangeend,int position){
        //complete segment is in the range
        if(rangestart<=segstart && rangeend>=segend){
            return tree[position];
        }

        //segment is not in the range
        if(rangestart>segend || rangeend<segstart){
            return 0;
        }

        //segment is partially in the range
        int mid = segstart + (segend-segstart)/2;

        return getSum(segstart,mid,rangestart,rangeend,position*2+1) +
                getSum(mid + 1,segend,rangestart,rangeend,position*2+2);
    }

    //recursive build of the tree in an array with the corresponding sum-values
    private long buildTree(long[] arr, int segstart, int segend, int nodeposition){
        //smallest segment (leaf)
        if(segstart==segend){
            tree[nodeposition] = arr[segstart];
            return arr[segstart];
        }

        int mid = segstart + (segend-segstart)/2;
        tree[nodeposition] = buildTree(arr,segstart,mid,nodeposition*2+1) +
                buildTree(arr,mid+1,segend, nodeposition*2+2);
        return tree[nodeposition];
    }


    public void updateValue(long[] arr, int position, long value){
        //input validation
        if (position < 0 || position > length - 1) {
            System.out.println("Invalid Input");
            return;
        }
        long diff = value - arr[position];
        arr[position] = value;

        updateValue(0,length,position,diff,0);
    }

    //recursive update all connected node to the value
    private void updateValue(int segstart, int segend, int position, long diff, int node){
        //actual position not in segment
        if (position < segstart || position > segend)
            return;

        tree[node] = tree[node] + diff;
        if(segend != segstart){
            int mid = segstart + (segend-segstart) / 2;
            updateValue(segstart,mid,position,diff,2*node+1);
            updateValue(mid+1,segend,position,diff,2*node+2);
        }
    }

    public static void main(String args[])
    {
        long arr[] = {1, 3, 4, 7, 11, 18};
        SegmentTree  tree = new SegmentTree(arr);

        System.out.println("Sum of values in given range = " +
              tree.getSum(1, 3));

        tree.updateValue(arr, 1, 10);

        System.out.println("Updated sum of values in given range = " +
            tree.getSum(1, 3));
    }

}
