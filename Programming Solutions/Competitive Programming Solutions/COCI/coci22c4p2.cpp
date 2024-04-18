#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int N,M,dp[2][5001][5001],v[2][5001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 1; i<=N; i++)cin>>v[0][i];
    cin>>M;
    for(int i = 1; i<=M; i++)cin>>v[1][i];
    for (int i = 0; i<=N; i++){
        for(int j = 0; j<=M; j++){
            if(!i&&!j)continue;
            for (int k = 0; k<2; k++) {
                dp[k][i][j]=100000000;
                if(0>i-(1-k)||j-k<0)continue;
                for (int l = 0; l<2; l++) {
                    if(v[k][i*(1-k)+j*k]==v[l][(i-(1-k))*(1-l)+(j-k)*l])dp[k][i][j]=min(dp[k][i][j],dp[l][i-(1-k)][j-k]+2);
                    else dp[k][i][j]=min(dp[k][i][j],dp[l][i-(1-k)][j-k]+1);
                }
            }
        }
    }
    cout<<min(dp[0][N][M],dp[1][N][M])<<endl;
}