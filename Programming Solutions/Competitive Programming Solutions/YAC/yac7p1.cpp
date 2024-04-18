#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
ll N, cnt;
struct n{ll v,i;};
bool cmp(n a, n b){return a.v<b.v;}
vector<n> all;
queue<ll> o,e;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(ll i = 1,a; i<=N; i++){
        cin>>a;
        all.push_back({a,i});
        cnt+=(a-1)/2;
    }
    sort(all.begin(), all.end(), cmp);
    for(ll i = 0; i<N; i++){
        if(all[i].v%2)o.push(all[i].i);
        else e.push(all[i].i);
    }
    if(o.empty()&&!e.empty())cout<<cnt+N<<"\n";
    else cout<<cnt<<"\n";
    if(!o.empty()){
        cout<<o.front()<<" ";
        o.pop();
    }
    while(!e.empty()){
        cout<<e.front()<<" ";
        e.pop();
    }
    while(!o.empty()){
        cout<<o.front()<<" ";
        o.pop();
    }
    cout<<"\n";
}