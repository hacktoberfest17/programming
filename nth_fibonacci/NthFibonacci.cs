using System;
using System.Numerics;

namespace NthFibonacci
{
    class Program
    {
        /// <summary>
        /// Get the nth Fibonnacci number
        /// </summary>
        /// <param name="n">Index of Fibonnaci number to calculate</param>
        /// <returns>BigInteger (to avoid int overflow for large values)</returns>
        static BigInteger nthFibonacci(int n)
        {
            BigInteger a = 0;
            BigInteger b = 1;
            BigInteger c;
            for (int i = 0; i < n; i++)
            {
                c = b;
                b += a;
                a = c;
            }
            return a;
        }

        /// <summary>
        /// Entry point, uses n from args or prompts for input
        /// </summary>
        /// <param name="args"></param>
        static void Main(string[] args)
        {
            int n = 0;
            string nIn = "";
            bool valid = false;
            if (args.Length < 1)
            {
                while (!valid)
                {
                    Console.Write("n: ");
                    nIn = Console.ReadLine();
                    valid = int.TryParse(nIn, out n);
                    if (valid && n < 1) valid = false;
                    if (!valid )
                    {
                        Console.Write("invalid, ");
                    }
                }
            } else
            {
                nIn = args[0];
                valid = int.TryParse(nIn, out n);
            }

            if (valid)
            {
                Console.WriteLine(nthFibonacci(n).ToString());
            }
            else
            {
                Console.WriteLine("invalid n: " + nIn);
            }

#if DEBUG
            Console.Read();
#endif
        }
    }
}
