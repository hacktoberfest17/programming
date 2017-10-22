package binarySearch;

class BinarySearch {
    int binarySearch(int arr[],int l, int r, int x) {
        if(r>=l) {
            int mid = l+(r-l)/2;
            if(arr[mid] == x) {
                return mid;
            }
            if(arr[mid] > x) {
                return binarySearch(arr,l,mid-1,x);
            }
            return binarySearch(arr,mid+1,r,x);
        }
        return -1;
    }
    public static void main(String args[]) {
        BinarySearch bb = new BinarySearch();
        int arr[] = {2,3,4,5,10};
        int n = arr.length;
        int x = 10;
        int result = bb.binarySearch(arr,0,n-1, x);
        if(result == -1) {
            System.out.print("Not FOund");
        }else {
            System.out.print("Found at index "+result);
        }
    }
}
