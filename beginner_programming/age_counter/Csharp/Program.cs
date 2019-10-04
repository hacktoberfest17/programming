using System;
using System.Numerics;

namespace age_counter
{
    class Program
    {
        public static void Main(string[] args)
        {
            int BirthMonth, BirthYear;
            int CurrentMonth, CurrentYear;
            int AgeYear, AgeMonth;
	
            Console.WriteLine("\n\n\t\t\tCount the age person\n\n");
	        Console.WriteLine("Enter Your Birth Year(Eg:1989):");
	        BirthYear = Convert.ToInt32(Console.ReadLine());
	
	        Console.WriteLine("\n\nEnter Your Birth Month(Eg:7):");
            BirthMonth = Convert.ToInt32(Console.ReadLine());
	
	        Console.WriteLine("\nEnter The Current Month(Eg:7):");
            CurrentMonth = Convert.ToInt32(Console.ReadLine());
	
	        Console.WriteLine("\nEnter The Current Year(Eg:2010):");
            CurrentYear = Convert.ToInt32(Console.ReadLine());
	
            AgeYear=CurrentYear-BirthYear;
            AgeMonth=CurrentMonth-BirthMonth;
	
	        Console.WriteLine("\n\n\t\tYour Age is {0} Years And {1} Months ",AgeYear,AgeMonth);
        }
    }
}