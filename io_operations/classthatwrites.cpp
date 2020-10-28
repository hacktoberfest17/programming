//person  objects do disk IO
#include<iostream>
#include<fstream>
using namespace std;
class person
{
private:
    char name[40];
    int age;
public:
    void getData()
    {
        cout << "\n Enter last name : " ; cin >> name;
        cout << "\n Enter age : " ; cin >> age;
    }
    void showData()
    {
        cout << "\n Name : " << name;
        cout << "\n Age : " << age;
    }
    void diskIn(int);
    void diskOut();
    static int diskCount();
};
void person::diskIn(int pn)
{
    ifstream infile;
    infile.open("Person.dat",ios::binary);
    infile.seekg(pn*sizeof(person));
    infile.read((char *)this,sizeof(*this));
}
void person::diskOut()
{
    ofstream outfile;
    outfile.open("Person.dat",ios::app | ios::binary);
    outfile.write((char *)this,sizeof(*this));
}
int person::diskCount()
{
ifstream infile;
infile.open("Person.dat",ios::binary);
infile.seekg(0,ios::end);
return (int)infile.tellg()/sizeof(person);
}
int main()
{
    person p;
    char ch;
    do
    {
        cout << "Enter data for person :: ";
        p.getData();
        p.diskOut();
        cout << "\nDo another (y/n)?";
        cin >> ch;
    }while(ch=='y');
    int n = person::diskCount();
    cout << "\n There are " << n << " persons in file\n";
    for(int j=0;j<n;j++)
    {
        cout << "\nPerson " << j;
        p.diskIn(j);
        p.showData();
    }
    cout << endl;
    return 0;
}
/*
Input:
Enter data for person :: 
 Enter last name : varad
 Enter age : 22
Do another (y/n)?y
Enter data for person :: 
 Enter last name : akshay
 Enter age : 19
Do another (y/n)?n

Output:
 There are 2 persons in file
Person 0
 Name : varad
 Age : 22
Person 1
 Name : akshay
 Age : 19
*/
