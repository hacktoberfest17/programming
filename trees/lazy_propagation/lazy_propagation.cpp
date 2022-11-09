// Solution of https://www.codechef.com/problems/SEACO using lazy propagation

#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define gc() getchar_unlocked()
 
inline void read(int &x){
        x=0;
        register char c=gc();
        for(;c<'0' || c>'9';c=gc());
         for(;c>='0' && c<='9';c=gc())
          x=(x<<3)+(x<<1)+(c-'0');
      }
 
long long int get_value_of_i(long long int *st, int ss, int se, int si, int i, long long int *lazy){
    if (ss == se){
        st[si] += lazy[si];
        st[si] = st[si]%(1000000000+7);
        lazy[si]=0;
        return st[si];
    }
    if(lazy[si] != 0){
        st[si] += lazy[si];
        st[si] = st[si]%(1000000000+7);
        lazy[si*2 + 1]  += st[si];
        lazy[si*2 + 2]  += st[si];
        lazy[si*2 + 1] = lazy[si*2 + 1]%(1000000000+7);
        lazy[si*2 + 2] = lazy[si*2 + 2]%(1000000000+7);
        lazy[si]=0;
        st[si]=0;
    }
    int mid = ss + (se-ss)/2;
    if (ss <= i && i<= mid)
        return get_value_of_i(st, ss, mid, 2*si+1, i, lazy);
    return get_value_of_i(st, mid+1, se, 2*si+2, i, lazy);
}
    
void updateRangeUtil(long long int *st, int si, int ss, int se, int us, int ue, int diff, long long int *lazy){
    
    if (ss>se or ss>ue or se<us)
        return;
    if (lazy[si] != 0){
        st[si] += lazy[si];
        st[si] = st[si]%(1000000000+7);
        if (ss != se){
            lazy[si*2 + 1]  += st[si];
            lazy[si*2 + 2]  += st[si];
            lazy[si*2 + 1] = lazy[si*2 + 1]%(1000000000+7);
            lazy[si*2 + 2] = lazy[si*2 + 2]%(1000000000+7);
            st[si] = 0;
        }
        lazy[si] = 0;
    }
    if (ss>=us and se<=ue){
        st[si] += diff;
        st[si] = st[si]%(1000000000+7);
        if (ss != se){
            lazy[si*2 + 1]   += st[si];
            lazy[si*2 + 2]   += st[si];
            lazy[si*2 + 1] = lazy[si*2 + 1]%(1000000000+7);
            lazy[si*2 + 2] = lazy[si*2 + 2]%(1000000000+7);
            st[si] = 0;
        }
        return;
    }
    int mid = ss+(se-ss)/2;
    updateRangeUtil(st, si*2+1, ss, mid, us, ue, diff, lazy);
    updateRangeUtil(st, si*2+2, mid+1, se, us, ue, diff, lazy);
}
    
void constructSTUtil(int arr, int ss, int se, long long int *st, int si){
    if (ss == se){
        st[si] = arr;
        return;
    }
    int mid = ss + (se-ss)/2;
    st[si] = 0;
    constructSTUtil(arr, ss, mid, st, si*2+1);
    constructSTUtil(arr, mid+1, se, st, si*2+2);
    return;
}
    
long long int *constructST(int arr, int n){
    int x = (int)(ceil(log2(n))); 
    int max_size = 2*(int)pow(2, x) - 1; 
    long long int *st = new long long int[max_size];
    constructSTUtil(arr, 0, n-1, st, 0);
    return st;
}
 
int main() {
    int t, n, m;
	read(t);
    while (t--){
        read(n);read(m);
        int x[m],y[m], z[m], i;
        for (i=0;i<m;i++){
            read(x[i]);read(y[i]);read(z[i]);
            y[i]--;z[i]--;
        }
        long long int *st = constructST(1, m);
        int max_size = 2*(int)pow(2, (int)(ceil(log2(m)))) - 1; 
        long long int *lazy = new long long int[max_size];
        memset(lazy, 0, sizeof(int)*max_size);
        long long int *st1 = constructST(0, n);
        max_size = 2*(int)pow(2, (int)(ceil(log2(n)))) - 1; 
        long long int *lazy1 = new long long int[max_size];
        memset(lazy1, 0, sizeof(int)*max_size);
        for (i=m-1;i>=0;i--){
            if (x[i] == 2)
                updateRangeUtil(st, 0, 0, m-1, y[i], z[i], get_value_of_i(st, 0, m-1, 0, i, lazy), lazy);
            else
                updateRangeUtil(st1, 0, 0, n-1, y[i], z[i], get_value_of_i(st, 0, m-1, 0, i, lazy), lazy1);
        }
        for (i=0;i<n;i++)
            printf("%lld ",get_value_of_i(st1, 0, n-1, 0, i, lazy1)%(1000000000+7));
        printf("\n");
    }
    return 0;
}
