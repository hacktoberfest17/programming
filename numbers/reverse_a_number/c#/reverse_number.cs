using System;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            int num, revNum, origNum = 0;

            Console.WriteLine("Enter a number: ");
            num = Int32.Parse(Console.ReadLine());
            while (num != 0)
            {
                revNum = num % 10;
                origNum = origNum * 10 + revNum;
                num = num / 10;
            }
            Console.WriteLine("Number Reversed: {0}", origNum);
            Console.ReadKey();
        }
    }
}
