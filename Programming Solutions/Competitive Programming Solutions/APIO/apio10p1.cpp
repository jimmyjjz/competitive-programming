#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
ll N,a,b,c,dp[1000001],presum[1000001],l=0;
ll eff(ll x){return a*x*x+b*x+c;}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>a>>b>>c;
    presum[0]=0;
    for(int i = 1; i<=N; i++){
        cin>>presum[i];
        presum[i]+=presum[i-1];
        dp[i]=-LONG_LONG_MAX;
    }
    dp[0]=0;
    for(int i = 1; i<=N; i++){
        for(ll j = l, e; j<i; j++){
            e=dp[j]+eff(presum[i]-presum[j]);
            if(e>dp[i]){
                dp[i]=e;
                l=j;
            }
        }
    }
    cout<<dp[N]<<"\n";
}