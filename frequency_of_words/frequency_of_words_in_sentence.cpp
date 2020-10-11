#include <bits/stdc++.h>
using namespace std;
int main() {
map<string , int>p;
string h,s="";getline(cin , h);
for(int i=0;i<h.length();i++){
   if(h[i]==' '){p[s]++;s="";}
   else{s+=h[i];}
}
p[s]++;
for(auto el : p) cout<<el.first<<" "<<el.second<<endl;
return 0;
}
