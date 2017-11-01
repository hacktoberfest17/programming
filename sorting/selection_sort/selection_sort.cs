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

            Console.WriteLine(string.Join(", ", SelectionSort(someInput)));
        }

        private static List<T> SelectionSort<T>(List<T> list) where T : IComparable
        {
            for (int i = 0; i < list.Count - 1; i++)
            {
                int minIndex = i;
                for (int j = i + 1; j < list.Count; j++)
                {
                    if (list[j].CompareTo(list[minIndex]) < 0)
                    {
                        minIndex = j;
                    }
                }

                T temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }

            return list;
        }
    }
}
