    #include<bits/stdc++.h>
    using namespace std;
    #define ll long long 
    #define mp make_pair
    #define pb push_back
    #define pp pair<ll,ll>
    #define s1(x) scanf("%lld",&x)
    #define s2(x,y) scanf("%lld%lld",&x,&y)
    #define ppp pair<ll,pair<ll,ll> >
    struct node
    {
       ll a[26];
    } *BIT[100000+5];
     
    ll n;
     
    void update1(char c , ll j)
    {
       ll i;
       
       for(i=j;i<=n;i+=i&-i)
       {
       	 
       	 (BIT[i]->a[c-'a'])++;
       }
    }
     
    void update2(char c , ll j)
    {
       ll i;
     
       for(i=j;i<=n;i+=i&-i)
       {
     
       	 (BIT[i]->a[c-'a'])--;
       }
    }
    struct node *sum(ll n)
    {
    	struct node *tmp = new node ;
    	for(ll i=n;i>0;i-=i&-i)
    	{
             for(ll j=0;j<26;j++)
             {
             	tmp->a[j] += BIT[i]->a[j];
             }
    	}
    	return tmp;
    }
    int main()
    {
    	ll i,j,k,m,t,q;
        ll x , y;
        
        cin >> n >> q;
        for(i=0;i<=n;i++)
        {
        	BIT[i] = new node;
        	for(j=0;j<26;j++)
        	{
        		BIT[i]->a[j] = 0;
        	}
        }
        string s;
        cin >> s;
        for(i=1;i<=s.size();i++)
        {
        	update1(s[i-1] , i);
        //	printf("hi\n");
        }
        while(q--)
        {
    	    cin >> x >> y;
    	    if(x == 2)
    	    {
    	    	ll z; 
    	    	cin >> z;
    	       node *tmp1 = sum(z);
    	       node *tmp2 = sum(y-1);
     
    	       ll f = 0;
    	       ll c = 1;
    	       for(i=0;i<26;i++)
    	       {
    	       	 if(abs(tmp1->a[i] - tmp2->a[i])%2 == 1)
    	       	 {
    	       	 	f++;
    	       	 	if(f > 1)
    	       	 	{
    	       	 		c = 0;
    	       	 		cout<<"no"<<endl;
    	       	 		break;
    	       	 	}
    	       	 }
    	       }
    	       if(c)
    	       	cout<<"yes"<<endl;
    	    }
    	    else
    	    {
    	    	char z;
    	    	cin >> z;
    	       update2(s[y-1],y);
    	       update1(z , y);
               s[y-1] = z;
    	    }
        } 
       return 0;
    }