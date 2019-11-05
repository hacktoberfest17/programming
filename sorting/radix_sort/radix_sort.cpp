#include <queue>
#include <math.h>

int getNthDigit(int n, int digit)
{
   return (n / (int)pow(10, digit)) % 10;
}

int getDigits(int n)
{
   return log10(n) + 1;
}

void radixSort(int* arr, int arrLength)
{
   std::vector<std::queue<int>> buckets(10);

   int digit = 0;
   bool sorted = false;

   while (!sorted)
   {
      sorted = true;

      for (int i = 0; i < arrLength; i++)
      {
         int val = arr[i];

         buckets.at(getNthDigit(val, digit)).push(val);

         sorted &= (digit + 1 >= getDigits(val));
      }
      ++digit;

      int arrIndex = 0;
      for (std::queue<int> &bucket : buckets)
      {
         while (!bucket.empty())
         {
            arr[arrIndex++] = bucket.front();
            bucket.pop();
         }
      }
   }
}
