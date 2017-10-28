#include <iostream>
#include <ctime>

using namespace std;

int main() {

   time_t now = time(0);
   tm *ltm = localtime(&now);

   if(1 + ltm->tm_mon==10 && ltm->tm_mday==31)
      cout<<"Happy Halloween!";
   else if (1 + ltm->tm_mon==10)
      cout<<"It is October, but today is not Halloween!";
   else
      cout<<"The current month is not October!";
}
