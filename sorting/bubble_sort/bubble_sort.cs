using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
 
namespace ConsoleAppBubbleSort
{
    class Program
    {
        static void Main(string[] args)
        {
            var array = new int[] { 10,9,9,8,7,5,23,123,1,23,1,7};
            int size = array.Length - 1;
 
            while (true)
            {
                bool isSorted = true;
                for (int i = 0; i < size; i++)
                {
                    if (array[i] > array[i + 1])
                    {
                        int tmpValue = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = tmpValue;
                        isSorted = false;
                    }
                }
                
                if (isSorted)
                    break;
            }
            foreach (var item in array)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();
        }
    }
}