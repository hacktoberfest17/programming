using System;
using System.Collections.Generic;

namespace Hacktoberfest
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> someInput = new List<int>()
            {
                37, 253, 0, 6213, 323, -5376, 1, 48, 5,
                -99999, 64, -55, 820, 2, 47, 8, -5, 48,
                3293, 683, 304, -8, 93, 400, 42, 42, 42
            };

            Console.WriteLine(string.Join(", ", MergeSort(someInput)));
        }

        private static List<T> MergeSort<T>(List<T> list) where T : IComparable
        {
            if (list.Count > 1)
            {
                List<T> leftList = MergeSort(list.GetRange(0, list.Count / 2));
                List<T> rightList = MergeSort(list.GetRange(list.Count / 2, (int)Math.Ceiling(list.Count / 2f)));
                return Merge(leftList, rightList);
            }
            else
            {
                return list;
            }
        }

        private static List<T> Merge<T>(List<T> leftList, List<T> rightList) where T : IComparable
        {
            List<T> mergedList = new List<T>();

            int leftIndex = 0;
            int rightIndex = 0;

            while (leftIndex < leftList.Count || rightIndex < rightList.Count)
            {
                if (rightIndex >= rightList.Count || (leftIndex < leftList.Count && leftList[leftIndex].CompareTo(rightList[rightIndex]) <= 0))
                {
                    mergedList.Add(leftList[leftIndex++]);
                }
                else
                {
                    mergedList.Add(rightList[rightIndex++]);
                }
            }

            return mergedList;
        }
    }
}
