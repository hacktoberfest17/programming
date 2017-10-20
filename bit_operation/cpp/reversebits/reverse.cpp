#include<bits/stdc++.h>
using namespace std;

int main()
 {
          unsigned int n;
          cin>>n;
          unsigned int rev = 0;
          for(int i=0;i<32;i++)
          {
              int t = n&(1<<i);
              if(t)
              {
                //rev=rev|(1<<(31-i));
                rev=rev+(1<<(31-i));
              }
          }
          cout<<rev<<endl;
	return 0;
}
