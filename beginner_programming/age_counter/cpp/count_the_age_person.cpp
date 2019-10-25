using namespace std;

#include<iostream>
#include<conio>

int BirthDate, BirthMonth, BirthYear;
int CurrentDate, CurrentMonth, CurrentYear;
int AgeDate, AgeYear, AgeMonth;

void dateDiff(){
        switch(CurrentMonth){
            case 3:
                if(CurrentYear%4==0)
                    AgeDate=29-(BirthDate-CurrentDate);
                else
                    AgeDate=28-(BirthDate-CurrentDate);
                break;
            case 1:
            case 2:
            case 4:
            case 6:
            case 8:
            case 9:
            case 11:
                AgeDate=31-(BirthDate-CurrentDate);
                break;
            case 5:
            case 7:
            case 10:
            case 12:
                AgeDate=30-(BirthDate-CurrentDate);
                break;
        }
}

int main()
{	cout<<"Count the age person\nEnter the following data:";
    cout<<"\n\nSample:\nSuppose you are born on 1 December 1997 and today is 24 October 2017\n";
    cout<<"Enter ONLY Date of your birth: 1\nEnter Month of your birth: 12\nEnter Year of your birth: 1997";
    cout<<"\nEnter ONLY Date of present day: 24\nEnter Month of present day: 10\nEnter Year of present day: 2017";
	
	cout<<"\n\nEnter ONLY Date of your birth:";
	cin>>BirthDate;
	cout<<"\nEnter Month of your birth:";
	cin>>BirthMonth;
	cout<<"\nEnter Year of your birth:";
	cin>>BirthYear;
	
	cout<<"\n\nEnter ONLY Date of present day:";
	cin>>CurrentDate;
	cout<<"\nEnter Month of present day:";
	cin>>CurrentMonth;
	cout<<"\nEnter Year of present day";
	cin>>CurrentYear;
	
	if(BirthMonth<=CurrentMonth){
        AgeYear=CurrentYear-BirthYear;
        if(BirthDate<=CurrentDate){
            AgeMonth=CurrentMonth-BirthMonth;
            AgeDate=CurrentDate-BirthDate;
        }
        else{
            AgeMonth=CurrentMonth-BirthMonth-1;
            dateDiff();
        }
	}
    else{
        AgeYear=CurrentYear-BirthYear-1;
            if(BirthDate<=CurrentDate){
                AgeMonth=12+CurrentMonth-BirthMonth;
                AgeDate=CurrentDate-BirthDate;
            }   
            else{
                AgeMonth=12+CurrentMonth-BirthMonth-1;
                dateDiff();
            }
    }
        
	
	
    cout<<"\nYou are "<<AgeYear<<"years, "<<AgeMonth<<" months and "<<AgeDate<<" days old!!";
	
	return 0;
}
