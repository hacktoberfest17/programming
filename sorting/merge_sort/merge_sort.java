import java.util.Scanner;

public class merge_sort 
{
    static void Merge(int a[], int l, int m, int r) 
    {
        int i1, i2, pos;
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for(int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for(int i = 0; i < n2; ++i)
            R[i] = a[m + 1 + i];

        i1 = i2 = 0; // index of array 1 and 2
        pos = l; // index of megred array
        while (i1 < n1 && i2 < n2) {
            if (L[i1] <= R[i2]) a[pos] = L[i1++];
            else a[pos] = R[i2++];
            ++pos;
        }
        while (i1 < n1) a[pos++] = L[i1++];
        while (i2 < n2) a[pos++] = R[i2++];
    }
    static void MergeSort(int a[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            //Sort 2 parts
            MergeSort(a, l, m);
            MergeSort(a, m + 1, r);
            Merge(a, l, m, r);
        }
    }
    public static void main(String args[])
    {
        int a[] = new int[100005];
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 1;i<=n;i++)
        {
            int r = scan.nextInt();
            a[i]=r;
        }
        MergeSort(a,1,n);
        for(int i = 1; i <= n; ++i) 
            System.out.print(a[i]+" ");
        System.out.println();
    }
}
