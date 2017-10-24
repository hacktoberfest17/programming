using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;

namespace Program
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            Console.WriteLine(
                "max Primzahl    nr. Primzahlen     ein Thread      zwei Threads      drei Threads      vier Threads");
            for (int i = 100000; i <= 51200000; i += 100000)
            {
                Dictionary<int, long> times = new Dictionary<int, long>();
                int anz = 0;
                for (int threads = 1; threads <= 4; threads++)
                {
                    Stopwatch watch = new Stopwatch();
                    watch.Start();
                    anz = new ConcurrentPrimCalculatior().Check(i, threads);
                    watch.Stop();
                    times[threads] = watch.ElapsedMilliseconds;
                }
                Console.WriteLine($"{i,-15} {anz,-18} {times[1],-15} {times[2],-17} {times[3],-17} {times[4],-12}");
            }

            Console.WriteLine("Done");
            Console.ReadLine();
        }
    }

    public class ConcurrentPrimCalculatior
    {
        public int Check(int maxToCheck, int maxParralell)
        {
            ConcurrentDictionary<int, bool> validPrims = new ConcurrentDictionary<int, bool>();
            // Create list of valids
            for (int i = 2; i < maxToCheck; i++)
                validPrims[i] = true;

            int lastToRemove = (int) Math.Sqrt(maxToCheck);

            // Remove everythin before lastToRemove Single-Threaded
            int currentPrim = 2;
            while (currentPrim <= lastToRemove)
            {
                int toRemove = currentPrim;
                for (int i = 2; i * currentPrim <= lastToRemove; i++)
                {
                    bool useless;
                    validPrims.TryRemove(i * currentPrim, out useless);
                }

                currentPrim = validPrims.Keys.ToList()[validPrims.Keys.ToList().IndexOf(currentPrim) + 1];
            }

            List<int> primsBeforeLastToCheck = new List<int>();
            foreach (int prim in validPrims.Keys)
                if (prim > lastToRemove)
                    break;
                else
                    primsBeforeLastToCheck.Add(prim);

            // Now remove mutiples of 0 - lastToRemove
            ParallelOptions options = new ParallelOptions {MaxDegreeOfParallelism = maxParralell};
            Parallel.ForEach(primsBeforeLastToCheck, options, toCheck =>
            {
                for (int mutiiple = toCheck * 2; mutiiple <= maxToCheck; mutiiple += toCheck)
                    lock (validPrims)
                    {
                        bool useless;
                        validPrims.TryRemove(mutiiple, out useless);
                    }
            });

            return validPrims.Count;
        }
    }
}