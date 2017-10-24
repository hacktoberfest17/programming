#include<iostream>
#include<cstdlib> 
#include<ctime> 
using namespace std; 
static const char alphnum[]="0123456789" "!@#$%^&*" "ABCDEFGHIJKLMNOPQRSTUVWXYZ" "abcdefghijklmnopqrstuvwxyz"; 
int strLen=sizeof(alphnum)-1; 
char GenRand()
{ 
 return alphnum[rand()%strLen]; 
} 
 int main() 
 { 
  int n,c=0,s=0;
  srand(time(0));
  cout<<"Enter the length of the password required:";
  cin>>n;
  cout<<n<<endl;
  cout<<"Your Password is:";
  N:
  char C;
  string D;
  for(int z=0; z < n; z++) 
   { 
     C=GenRand();
     D+=C;
     if(isdigit(C))
     {
         c++;
     }
    if(C=='!' || C=='@' || C=='$' || C=='%' ||  C=='^' || C=='&'|| C=='*'|| C=='#')
    {
        s++;
    }
   }
   if(n>2 && (s==0 || c==0))
   {
      goto N; 
   }
   cout<<D; 
   cout<<endl<<endl<<"                 THANK YOU";
   return 0; 
}
