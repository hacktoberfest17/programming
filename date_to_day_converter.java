//POJO class
//Program to Convert date into day
import java.util.*;
class Converter {     //class of conversion
	//int dob[]=new int[8]; //not required but can be used
	int year;
	int month;
	int date;
	int Reminder;
	int keyValues[] = {0,3,3,6,1,4,6,2,5,0,3,5}; //Values alloted for the specific month according to remaining days in the previous month
	boolean isLeap()   //function which returns whether the year is leap or not
	{
	int a=this.year;
	if(a%4==0)
	{
		return true;
	}
	else if(a%400==0)
	{
		return true;
	}
	else
	{
		return false;
	}	}//end of isLeap()
	int getReminder()  //Function which calculates reminder from the year and date we entered
	{
		int a=this.year;
		a=a%100;
		int b=a/4;
		this.Reminder=a+b;
		switch(month)
		{
		case 1: break;
		case 2: this.Reminder+=3;break;
		case 3: this.Reminder+=3;break;
		case 4: this.Reminder+=6;break;
		case 5: this.Reminder+=1;break;
		case 6: this.Reminder+=4;break;
		case 7: this.Reminder+=6;break;
		case 8: this.Reminder+=2;break;
		case 9: this.Reminder+=5;break;
		case 10: this.Reminder+=0;break;
		case 11: this.Reminder+=3;break;
		case 12: this.Reminder+=5;break;
		}
		this.Reminder+=this.date;
		this.Reminder%=7;
		if(isLeap())
		{
		 return Reminder-=1;
		}
		else 
        	return Reminder;
	}//end of getReminder()
	void getDay(int reminder)  //Function to find out and display the actual day on the given date
	{
		if(reminder!=0)
		{
		switch(reminder)
		{
		case 1: System.out.println("Monday");break;
		case 2: System.out.println("Tuesday");break;
		case 3: System.out.println("Wednesday");break;
		case 4: System.out.println("Thursday");break;
		case 5: System.out.println("Friday");break;
		case 6: System.out.println("Saturday");break;
		}
		}
		else
		{
			System.out.println("Sunday");
		}
	}  
}
//Driver class
class DrivingDay extends Converter{  //Driver class for Converter
	public static void main(String[] args) {  //main() method
		System.out.println("Welcome to Birth-Day Calculator");
		Scanner sc = new Scanner(System.in);  //Scanner object for taking input
		DrivingDay ob = new DrivingDay();  //Instance Creation
		
		//Taking the Date of Birth from User
		System.out.println("Enter your date of birth in the following format,");
		System.out.println("Enter the Year: ");
		ob.year=sc.nextInt();
		System.out.println("Enter the Month: ");
		ob.month=sc.nextInt();
		System.out.println("Enter the date: ");
		ob.date=sc.nextInt();
		//Calculating Reminder
		int reminder=ob.getReminder();	
		//Printing the Birth-Day
		System.out.println("Your Birth Day Was: ");
	    ob.getDay(reminder);
	    System.out.println("Thank You");
	}
}
