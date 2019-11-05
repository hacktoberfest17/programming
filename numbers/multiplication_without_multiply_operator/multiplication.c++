using namespace std;

#include "iostream"

int multiplyByTen(int n)
{
	return (n<<1) + (n<<3);
}

int main()
{

	int num;
	cout<<"Enter a number \n";
	cin>>num;
	cout<<num<<" * 10 = "<<multiplyByTen(num);

}
