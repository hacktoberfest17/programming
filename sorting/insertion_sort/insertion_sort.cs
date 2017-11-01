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

            Console.WriteLine(string.Join(", ", InsertionSort(someInput)));
        }

        private static List<T> InsertionSort<T>(List<T> list) where T : IComparable
        {
            for (int i = 1; i < list.Count; i++)
            {
                for (int j = i; j > 0; j--)
                {
                    if (list[j].CompareTo(list[j - 1]) < 0)
                    {
                        T temp = list[j];
                        list[j] = list[j - 1];
                        list[j - 1] = temp;
                    }
                }
            }

            return list;
        }
    }
}
