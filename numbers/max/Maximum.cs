namespace Hacktober_Numbers
{
    class Maximum
    {
        public static double Max(params double[] nums)
        {
            if (nums.Length == 0)
            {
                return double.NaN;
            }
            double biggest = nums[0];
            for (int i = 1; i < nums.Length; i++)
            {
                if (nums[i] > biggest)
                    biggest = nums[i];
            }
            return biggest;
        }
    }
}
