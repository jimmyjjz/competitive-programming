#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N,M,m=0,zero=0,vsize,dp[301][301][301][2];
vector<int> v;
bool z = false;
int re(int l, int r, int n, int d){
    if(dp[l][r][n][d]!=INT_MAX)return dp[l][r][n][d];
    if(d)dp[l][r][n][1]=min((l>0?re(l-1,r,n-1,0)+n*(v[r]-v[l-1]):INT_MAX),(r<vsize-1?re(l,r+1,n-1,1)+n*(v[r+1]-v[r]):INT_MAX));
    else dp[l][r][n][0]=min((l>0?re(l-1,r,n-1,0)+n*(v[l]-v[l-1]):INT_MAX),(r<vsize-1?re(l,r+1,n-1,1)+n*(v[r+1]-v[l]):INT_MAX));
    return dp[l][r][n][d];
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    for(int i=0;i<301;i++)for(int j=0;j<301;j++){
        dp[i][j][0][0]=0;dp[i][j][0][1]=0;
        for(int k=1;k<301;k++){dp[i][j][k][0]=INT_MAX;dp[i][j][k][1]=INT_MAX;}
    }
    cin>>N>>M;
    for(int i = 0,x; i<N; i++){
        cin>>x;
        if(x==0)z=true;
        v.push_back(x);
    }
    if(!z)v.push_back(0);
    vsize=v.size();
    sort(v.begin(), v.end());
    for(int i = 0; i<vsize; i++)if(v[i]==0){zero=i;break;}
    for(int i = 0; i<vsize; i++)m=max(m,i*M-re(zero,zero,i,0));
    cout<<m+(z?M:0)<<"\n";
}