/**
 * IsPrime.c
 * Checks if the inputed number is a prime number using
 * the miller-rabin method for speedy results. Works for numbers up to 3317044064679887385961981.
 * Author: nicktheway (https://github.com/nicktheway)
 * Made for the Hacktoberfest17 on 22/10/2017
 */

using System;
using System.Linq;
using System.Numerics;

class IsPrime
{
    /**
     * The Main Function of the program
     */
    static void Main(string[] args)
    {
        //The number variable, can hold integer values up to 9223372036854775807.
        ulong number = 0;
        BigInteger input;
        bool possitiveInputFlag;
        //Program loop
        while (true)
        {
            //----Read the number from the keyboard----
            do {
                Console.Write("Enter a positive integer (or 0 to terminate the program): ");
                possitiveInputFlag = BigInteger.TryParse(Console.ReadLine(), out input);

                if (input < ulong.MaxValue)
                    number = (ulong)input;

            } while (input < 0 ||  !possitiveInputFlag);

            if (input == 0) break;
            InitializeHighLimits();
            int[] a = FittingA(input);

            //----Check if the number is prime and print result----
            if (number != 0)
            {
                if (FastPrimeCheck(number, a.Count(), a))
                    Console.WriteLine(number + " is a prime!");
                else
                    Console.WriteLine(number + " is not a prime!");
            }
            else
            {
                if (FastPrimeCheck(input, a.Count(), a))
                    Console.WriteLine(input + " is a prime!");
                else
                    Console.WriteLine(input + " is not a prime!");
            }
        }
    }

    /**
     * Miller-Rabin primality test method for numbers up to ulong.maxValue
     */ 
    public static bool FastPrimeCheck(ulong number, int k, params int[] values)
    {
        //Some ultra fast results.
        if (number == 1) return true;
        for (int i = 0; i < k; i++)
        {
            if (number ==(ulong) values[i]) return true;
        }
        if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) return false;

        
        ulong[] a = new ulong[k];
        Random rand = new Random();
        ulong x;

        //----number = 2^r * d, Finding r, d----
        ulong d = number - 1;
        int r = 0;
        while (d % 2 == 0)
        {
            d /= 2;
            r++;
        }

        //----passing values to a----

        for (int i = 0; i < values.Count(); i++)
        {
            a[i] = (ulong)values[i];
        }
        
        //----passing random values (not 100% correct result, increasing k increases chances for correct result)----

        for (int i = 0; i < k; i++)
        {
            bool flag = false;
            //If there were not provided enough values for a
            if (values.Count() <= i)
            {
                a[i] = LongRandom(2, number - 2, rand);
            }
            
            x = (ulong) BigInteger.ModPow(a[i], d, number);
            
            if (x == 1 || x == number - 1) continue;

            for (int j = 0; j < r - 1; j++)
            {
                x = (ulong)BigInteger.ModPow(x, 2, number);
                if (x == 1)
                {
                    return false;
                }
                else if (x == number - 1)
                {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            return false;
        }

        return true;
    }

    /**
    * Miller-Rabin primality test method for very big numbers
    */
    public static bool FastPrimeCheck(BigInteger number, int k, params int[] values)
    {
        //Some ultra fast results.
        if (number == 1) return true;
        for (int i = 0; i < k; i++)
        {
            if (number == values[i]) return true;
        }
        if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) return false;


        int[] a = new int[k];
        Random rand = new Random();
        BigInteger x;

        //----number = 2^r * d, Finding r, d----
        BigInteger d = number - 1;
        int r = 0;
        while (d % 2 == 0)
        {
            d /= 2;
            r++;
        }
        //----passing values to a----

        for (int i = 0; i < values.Count(); i++)
        {
            a[i] = values[i];
        }

        //----passing random values (not 100% correct result, increasing k increases chances for correct result)----

        for (int i = 0; i < k; i++)
        {
            bool flag = false;
            if (values.Count() <= i)
            {
                a[i] =(Int32) LongRandom(2,Int32.MaxValue - 2, rand);
            }
            x = BigInteger.ModPow(a[i], d, number);
            
            if (x == 1 || x == number - 1) continue;

            for (int j = 0; j < r - 1; j++)
            {
                x = BigInteger.ModPow(x, 2, number);
                if (x == 1)
                {
                    return false;
                }
                else if (x == number - 1)
                {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            return false;
        }

        return true;
    }
    /**
     * Function for exporting an Int64 from a string
     * Returns -1 if the string is not an int or is of limits (bigger than Inte64.MaxValue)
     */
    public static Int64 ReadInt64(string value)
    {
        Int64 val = -1;
        if (!Int64.TryParse(value, out val))
            return -1;
        return val;
    }

    /**
     * Generates a 64bit random number
     */
    static ulong LongRandom(ulong min, ulong max, Random rand)
    {
        byte[] buffer = new byte[8];
        rand.NextBytes(buffer);
        ulong longRand = (ulong) BitConverter.ToInt64(buffer, 0);

        return (longRand % (max - min)) + min;
    }

    /**
     * Fast exponentiation function, using mod to keep results small
     */ 
    static long ModularPow(long baseNum, long exponent, long modulus)
    {
        if (modulus == 1) return 0;
        BigInteger ca = 1;
        long c = 1;
        while (exponent > 0)
        {
            if (exponent % 2 == 1)
            {
                ca = (ca * baseNum) % modulus;
            }
            baseNum = (baseNum * baseNum) % modulus;
            exponent >>= 1;
        }
        c = (long)ca;
        return c;
    }

    //Data from "https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test"
    //if n < 2,047, it is enough to test a = 2;
    //if n < 1,373,653, it is enough to test a = 2 and 3;
    //if n < 9,080,191, it is enough to test a = 31 and 73;
    //if n < 25,326,001, it is enough to test a = 2, 3, and 5;
    //if n < 3,215,031,751, it is enough to test a = 2, 3, 5, and 7;
    //if n < 4,759,123,141, it is enough to test a = 2, 7, and 61;
    //if n < 1,122,004,669,633, it is enough to test a = 2, 13, 23, and 1662803;
    //if n < 2,152,302,898,747, it is enough to test a = 2, 3, 5, 7, and 11;
    //if n < 3,474,749,660,383, it is enough to test a = 2, 3, 5, 7, 11, and 13;
    //if n < 341,550,071,728,321, it is enough to test a = 2, 3, 5, 7, 11, 13, and 17.
    //if n < 3,825,123,056,546,413,051, it is enough to test a = 2, 3, 5, 7, 11, 13, 17, 19, and 23.
    //if n < 318,665,857,834,031,151,167,461, it is enough to test a = 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, and 37.
    //if n < 3,317,044,064,679,887,385,961,981, it is enough to test a = 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, and 41.
    static readonly int limit1  = 2047;
    static readonly int limit2  = 1373653;
    static readonly int limit3  = 9080191;
    static readonly int limit4  = 25326001;
    static readonly long limit5 = 3215031751;
    static readonly long limit6 = 4759123141;
    static readonly long limit7 = 1122004669633;
    static readonly long limit8 = 2152302898747;
    static readonly long limit9 = 3474749660383;
    static readonly long limit10 = 341550071728321;
    static readonly long limit11 = 3825123056546413051;
    static BigInteger limit12;
    static BigInteger limit13;

    static bool InitializeHighLimits()
    {
        bool flag = true;
        flag &= BigInteger.TryParse(   "318665857834031151167461",   out limit12);
        flag &= BigInteger.TryParse(  "3317044064679887385961981",   out limit13);
        return flag;
    }

    static readonly int[] a1    = { 2 };
    static readonly int[] a2    = { 2, 3};
    static readonly int[] a3    = { 31, 73 };
    static readonly int[] a4    = { 2, 3, 5 };
    static readonly int[] a5    = { 2, 3, 5, 7};
    static readonly int[] a6    = { 2, 7, 61};
    static readonly int[] a7    = { 2, 13, 23, 1662803};
    static readonly int[] a8    = { 2, 3, 5, 7, 11 };
    static readonly int[] a9    = { 2, 3, 5, 7, 11, 13 };
    static readonly int[] a10   = { 2, 3, 5, 7, 11, 13, 17 };
    static readonly int[] a11   = { 2, 3, 5, 7, 11, 13, 17, 19, 23 };
    static readonly int[] a12   = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };
    static readonly int[] a13   = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41 };

    /**
     * Returns the right array based in the number we want to check
     */
    static int[] FittingA(BigInteger number)
    {
        if (number < limit1) return a1;
        if (number < limit2) return a2;
        if (number < limit3) return a3;
        if (number < limit4) return a4;
        if (number < limit5) return a5;
        if (number < limit6) return a6;
        if (number < limit7) return a7;
        if (number < limit8) return a8;
        if (number < limit9) return a9;
        if (number < limit10) return a10;
        if (number < limit11) return a11;
        if (number < limit12) return a12;
        if (number < limit13) return a13;


        return new int[0];
    }
}
