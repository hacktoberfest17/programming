//binary input and output integers
#include<fstream>
#include<iostream>
using namespace std;
const int MAX = 80;
int buff[MAX];

int main()
{
    for(int j=0;j<MAX;j++)
    {
        buff[j]=j;
    }
    ofstream os("edata.dat",ios::binary);
    os.write(reinterpret_cast<char *>(buff),MAX*sizeof(int));
    os.close();
    for(int j=0;j<MAX;j++)
    {
        buff[j]=0;
    }
    ifstream is("edata.dat",ios::binary);
    is.read(reinterpret_cast<char *>(buff),MAX*sizeof(int));
    for(int k=0;k<MAX;k++)
    {
        if(buff[k]!=k)
        {
            cerr << "DATA IS INCORRECT\n";
        }
        cout << "Data is Correct\n";
    }
    return 0;
}
/*Input:
Input is the edata.dat binary file and this program reads data from the file and checks if data is correct.

Output:
Data is Correct
Data is Correct
Data is Correct
Data is Correct
Data is Correct
Data is Correct
Data is Correct
Data is Correct
Data is Correct
Data is Correct
Data is Correct
*/
