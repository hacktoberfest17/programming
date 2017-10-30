namespace Programming
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    /// <summary>
    /// Represents a simple Fibonacci series caclculator.
    /// </summary>
    public class FibonacciSeries
    {
        /// <summary>
        /// Default number of Fibonacci values to output when invalid parameters are given.
        /// </summary>
        private const int DEFAULT_SERIES_LENGTH = 20;

        /// <summary>
        /// Maximum length of series; prevents overflows in output.
        /// </summary>
        private const int MAX_SERIES_LENGTH = 92;

        /// <summary>
        /// Main entry point to test printing Fibonacci series.
        /// </summary>
        /// <param name="args">Command line arguments.</param>
        static void Main(string[] args)
        {
            int nth;
            if (args.Length > 0 && int.TryParse(args[0], out nth))
            {
                nth = Math.Min(nth, MAX_SERIES_LENGTH);
            }
            else
            {
                nth = DEFAULT_SERIES_LENGTH;
            }
            Print(Fibonacci(nth));
        }

        /// <summary>
        /// Prints collection to stdout as comma separated list.
        /// </summary>
        /// <param name="values">Collection to print.</param>
        private static void Print(IEnumerable<long> values)
        {
            Console.WriteLine(string.Join(", ", values));
        }

        /// <summary>
        /// Calculates the Fibonacci series.
        /// </summary>
        /// <param name="n">Length of the series.</param>
        /// <returns>A <see cref="IEnumerable{long}"/> collection of first <paramref name="n"/> Fibonacci values.</returns>
        private static IEnumerable<long> Fibonacci(int n)
        {
            var fibs = new List<long>(n) { 1, 1 };
            if (n <= fibs.Count)
            {
                return fibs.Take(n);
            }

            for (int i = fibs.Count; i < n; i++)
            {
                fibs.Add(fibs[i - 1] + fibs[i - 2]);
            }

            return fibs;
        }
    }
}
