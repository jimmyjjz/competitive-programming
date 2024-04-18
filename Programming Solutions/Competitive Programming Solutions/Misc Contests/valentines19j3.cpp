#include <bits/stdc++.h>
#include <iostream>
using namespace std;
string s;
int len;
long long dp[4][10000];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>s;
    len=s.length();
    for(int i = 0; i<len; i++){
        if(s[i]=='l')dp[0][i]++;
        else if(s[i]=='o')dp[1][i]++;
        else if(s[i]=='v')dp[2][i]++;
        else if(s[i]=='e')dp[3][i]++;
    }
    for(int i = 1; i<len; i++)dp[0][i]+=dp[0][i-1];
    for(int i = 1; i<4; i++){
        if(dp[i][0]!=0)dp[i][0]=dp[i-1][0];
        for(int j = 1; j<len; j++){
            if(dp[i][j]!=0)dp[i][j]+=dp[i-1][j]-1;
            dp[i][j]+=dp[i][j-1];
        }
    }
    cout<<dp[3][len-1]<<"\n";
}