// C++ program to get the size of the longest common subsequence in two strings
// The sequence follows an order but is not contiguous

# include <bits/stdc++.h>
using namespace std;

int longest_common_subsequence(string s1,string s2,int l1,int l2){
	int best[l1+10][l2+10];
	
	for (int i = 0; i <= l1; i++){
		best[i][0] = 0;
	}
	
	for (int j = 0; j <= l2; j++){
		best[0][j] = 0;
	}
	
	for (int i = 1; i <= l1; i++){
		for (int j = 1; j <= l2; j++){
			if (s1[i-1] == s2[j-1]){
				best[i][j] = 1 + best[i-1][j-1];
			}else{
				best[i][j] = max(best[i-1][j],best[i][j-1]);
			}
		}
	}
	return best[l1][l2];
}

int main(){
	string s1, s2;
	cin>>s1>>s2;
	
	int l1 = s1.size();
	int l2 = s2.size();
	
	int ans = longest_common_subsequence(s1, s2, l1, l2);
	cout<<ans;
	return 0;
}
