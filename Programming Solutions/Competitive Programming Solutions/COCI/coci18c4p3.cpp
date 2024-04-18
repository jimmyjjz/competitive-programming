#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
struct b{int w,h;};
bool cmp(b a, b b){return a.h<b.h;}
priority_queue<int> pq;
int N,K;
ll m=LONG_LONG_MAX,tot=0;
vector<b> v;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>K;
    for(int i = 0,w,h; i<N; i++){
        cin>>w>>h;
        v.push_back({w,h});
    }
    sort(v.begin(), v.end(), cmp);
    for(int i = 1,j=0; i<=1000000; i++){
        while(j<N&&v[j].h<=i){tot+=v[j].w;pq.push(v[j++].w);}
        while(pq.size()>K){tot-=pq.top();pq.pop();}
        if(pq.size()==K)m=min(tot*i,m);
    }
    cout<<m<<"\n";
}