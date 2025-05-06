#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int dp[300][300],N,M,m=INT_MAX;
string a,b;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i = 0; i<300; i++)for(int j = 0; j<300; j++)dp[i][j]=INT_MAX;
    cin>>a>>b;
    for(int i = 0; i<N; i++)if(a[i]==b[0])dp[0][i]=0;
    for(int i = 1; i<M; i++)
        for(int j = 0; j<N; j++)
            if(dp[i-1][j]!=INT_MAX)
                for(int k = 0; k<N; k++)
                    if(a[k]==b[i]){
                        if(k>0&&a[k-1]==b[i-1])dp[i][k]=min(dp[i][k],dp[i-1][j]+abs(j-(k-1))+1);
                        if(k<N-1&&a[k+1]==b[i-1])dp[i][k]=min(dp[i][k],dp[i-1][j]+abs(j-(k+1))+1);
                    }
    for(int i = 0; i<N; i++)m=min(m,dp[M-1][i]);
    cout<<(m==INT_MAX?-1:m)<<"\n";
}