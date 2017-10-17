using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hacktoberfest
{
    class Program
    {
        static void Main(string[] args)
        {
            int number, result = 1;

            Console.WriteLine("Please enter the number you wish to factorize");
            number = int.Parse(Console.ReadLine());

            while (number != 1)
            {
                result = result * number;
                number = number - 1;
            }
            Console.WriteLine(result);
            Console.ReadKey();

        }
    }
}
