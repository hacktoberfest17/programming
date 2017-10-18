/*Next higher number with same number of set bits*/
#include <iostream>
#include <stdint.h>
using namespace std;

typedef unsigned int uint_t;
uint_t next_higher(uint_t x);
int main()
{
	int x;
	cout<<"Enter a number.\n";
	cin>>x;

	cout<<"Next higher number with same number of set bits is :"<<next_higher(x)<<"\n";
	return 0;
}

uint_t next_higher(uint_t x)
{
	uint_t smallest, ripple, ones;

	smallest = x & -(signed)x;
	ripple = x+smallest; /*first half of answer*/
	ones = x^ripple;
	ones = (ones>>2)/smallest; /*second half of answer*/
	return ones|ripple;
}