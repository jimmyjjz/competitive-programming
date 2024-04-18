#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int T;
ll N,S;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>T;
    for(int i = 0; i<T; i++){
        cin>>N>>S;
        ll sum = (N*(N+1))/2;
        if((sum-S)%2)cout<<min(N-(sum-S+1)/2,(sum-S)/2-1)+1<<"\n";
        else cout<<min(N-(sum-S)/2,(sum-S)/2-1)<<"\n";
    }
}