#include<bits/stdc++.h>
#define fi          first
#define se          second
#define mp 	    make_pair
#define pb          push_back
#define Sd(a) scanf("%d",&a)
#define Sl(a) scanf("%lld",&a)
#define Pd(a) printf("%d\n",a)
#define Pl(a) printf("%lld\n",a)
using namespace std;
typedef long long ll;typedef long long LL;
void solve();
ll ans=0;
//vector<ll>v;
#define loop(x,i,n) for(int x=i;x<n;x++)
#define TRvi(c, it) for (vi::iterator it = (c).begin(); it != (c).end(); it++)
#define TRvii(c, it) for (vii::iterator it = (c).begin(); it != (c).end(); it++)
inline void rd(ll n ,vector<ll>& v){while(n--){ll input;Sl(input);v.push_back(input);}}

inline int getint(){
    int w=0,q=0; char c=getchar(); while((c<'0'||c>'9') && c!='-') c=getchar();
    if(c=='-') q=1,c=getchar(); while (c>='0'&&c<='9') w=w*10+c-'0',c=getchar(); return q?-w:w;
}

inline string IntToString(LL a){
  char x[100];
  sprintf(x,"%lld",a); string s = x;
  return s;
}

inline LL StringToInt(string a){
  char x[100]; LL res;
  strcpy(x,a.c_str()); sscanf(x,"%lld",&res);
  return res;
}

inline string readS(void){
  char x[1000005];
  scanf("%s",x); string s = x;
  return s;
}

inline string uppercase(string s){
  int n = s.size(); 
  loop(i,0,n) if (s[i] >= 'a' && s[i] <= 'z') s[i] = s[i] - 'a' + 'A';
  return s;
}

inline string lowercase(string s){
  int n = s.size(); 
  loop(i,0,n) if (s[i] >= 'A' && s[i] <= 'Z') s[i] = s[i] - 'A' + 'a';
  return s;
}

int min2(int x, int y, int z)
{
   if (x < y)
      return (x < z)? x : z;
   else
      return (y < z)? y : z;
}


int main(){int T=1;//Sd(T);
while(T--)
{solve();

}
return 0;}

void solve(){ll n;Sl(n); vector<ll>v; rd(n,v);



}