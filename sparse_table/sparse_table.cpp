/**
 * autor: Edimar Chaves Jr.
 * 02/10/2019 12:31:11
 * 
 * Solves static Range Maximum(or minimum with simple changes) Query problem.
 * Sparse Table
**/

#include <bits/stdc++.h>

using namespace std;

#define MAXN 100009
#define LOGN 20

int a[MAXN];
int table[LOGN][MAXN];

struct sparse_table
{
    void build(int n){

        for (int i = 1; i <= n;i++)
            table[0][i] = a[i];

        for(int i = 1; (1 << i) <= n; i++){

            int k = n - (1 << i) + 1;

            for (int j = 1; j <= k; j++){
                table[i][j] = max(table[i - 1][j], table[i - 1][j + (1 << (i - 1))]);
            }
        }
    }

    int query(int l,int r){
        int k   =__lg(r - l + 1);

        return max(table[k][l], table[k][r - (1 << k) + 1]);
    }

};


int main(){ return 0;}