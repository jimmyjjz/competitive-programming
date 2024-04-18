#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int N,C;
    cin>>N>>C;
    long long dp[N+1][C+1][2] = {0};
	for(int i = 1,a,b,c,d; i<=N; i++) {
        cin>>a>>b>>c>>d;
        for(int j = 1; j<=C; j++) {
	        dp[i][j][0]=max(dp[i-1][j][0],max(dp[i-1][j][1],j>=c?max(dp[i][j][0],dp[i][j-c][1]+d):-1));
	        dp[i][j][1]=max(dp[i-1][j][0],max(dp[i-1][j][1],j>=a?max(dp[i][j][1],dp[i][j-a][0]+b):-1));
	    }
	}
	cout<<max(dp[N][C][0], dp[N][C][1])<<endl;
}