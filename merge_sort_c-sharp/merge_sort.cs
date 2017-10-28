// From the Wikipedia Merge Sort algorithm
// Top-down implementation
// inputArray is the array to be sorted
// The result gets printed in the console once it has finished sorting
using System;

class Program
{
    static void Main(string[] args)
    {

        int[] inputArray = { 9, 3, 2, 4, 1 };
        int[] workArray = new int[inputArray.Length];

        Console.Write("Input Array: ");
        PrintArray(inputArray);

        Mergesort(inputArray, workArray, inputArray.Length);
        
        Console.Write("Sorted Array: ");
        PrintArray(inputArray);

    }

    static void PrintArray(int[] array)
    {
        Console.Write("{ ");
        for (int i = 0; i < array.Length - 1; i++)
        {
            Console.Write(array[i] + ", ");
        }
        Console.Write(array[array.Length - 1] + " }\n");
    }

    static void Mergesort(int[] A, int[] B, int n)
    {
        CopyArray(A, 0, n, B);
        SplitMerge(B, 0, n, A);
    }

    static void SplitMerge(int[] B, int startIndex, int endIndex, int[] A)
    {
        if (endIndex - startIndex < 2) return;

        int middleIndex = (startIndex + endIndex) / 2;

        SplitMerge(A, startIndex, middleIndex, B);
        SplitMerge(A, middleIndex, endIndex, B);
        Merge(B, startIndex, middleIndex, endIndex, A);
    }

    static void Merge(int[] A, int startIndex, int middleIndex, int endIndex, int[] B)
    {
        int i = startIndex;
        int j = middleIndex;

        for (int k = startIndex; k < endIndex; k++)
        {
            if (i < middleIndex && (j >= endIndex || A[i] <= A[j]))
            {
                B[k] = A[i];
                i++;
            }
            else
            {
                B[k] = A[j];
                j++;
            }
        }
    }

    // currently only used to copy the original array to the work array 
    static void CopyArray(int[] source, int startIndex, int endIndex, int[] temp)
    {
        for (int k = startIndex; k < endIndex; k++)
        {
            temp[k] = source[k];
        }
    }
}

