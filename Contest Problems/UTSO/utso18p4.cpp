#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
struct p{int a,b;};
bool cmp(p a, p b){return a.a<b.a;}
int N;
vector<p> v[100001];
ll sectionMax(int x){
    ll ta=0,tb=0,s=v[x].size(),m=0;
    for(p i : v[x])ta+=i.a;
    for(int i = 0; i<s; i++){
        ta-=v[x][i].a;
        tb+=v[x][i].b;
        m=max(min(ta,tb),m);
    }
    return m;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0,a,b; i<N; i++){
        cin>>a>>b;
        v[a+b].push_back({a,b});
    }
    ll m=0;
    for(int i = 0; i<=100000; i++){
        sort(v[i].begin(), v[i].end(), cmp);
        m=max(m,sectionMax(i));
    }
    cout<<m<<"\n";
}