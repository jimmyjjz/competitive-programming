//solution somewhat influenced by a cf 1d1d optimization blog
#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
struct p{int a,b;};
int N,S,T[10001],F[10001],dp[10001];
vector<p> v;
int c(int i, int j){return T[j]*(F[j]-F[i])+S*(F[N]-F[i]);}
int bsearch(int n){
    int l=0,h=v.size()-1;
    while(l<=h){
        int m=(l+h)/2;
        if(v[m].a>=n)h=m-1;
        else l=m+1;
    }
    return h+1;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>S;
    for(int i = 1; i<=N; i++){
        cin>>T[i]>>F[i];
        T[i]+=T[i-1];F[i]+=F[i-1];
    }
    dp[0]=0;
    v.push_back({0,0});
    for(int i = 1; i<=N; i++){
        int temp = v[bsearch(i+1)-1].b;
        dp[i]=dp[temp]+c(temp,i);
        while(!v.empty()){
            int j = v.back().a, pre = v.back().b;
            if(j>i&&dp[i]+c(i,j)<dp[pre]+c(pre,j))v.pop_back();
            else {
                int l=j+1, h=N+1;
                while(l<h) {
                    int m=(l+h)/2;
                    if(dp[i]+c(i,m)<=dp[pre]+c(pre,m))h=m;
                    else l=m+1;
                }
                if(h!=N+1)v.push_back({h,i});
                break;
            }
        }
        if(v.empty())v.push_back({0,i});
    }
    cout<<dp[N]<<"\n";
}