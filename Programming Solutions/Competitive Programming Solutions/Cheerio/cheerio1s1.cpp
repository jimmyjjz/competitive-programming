#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N;
ll D,t=0,pre=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>D;
    for(ll i=0,p,r,g; i<N; i++,pre=p){
        cin>>p>>r>>g;
        t+=p-pre;
        if(t%(r+g)<r)t+=r-t%(r+g);
    }
    t+=D-pre;
    cout<<t<<"\n";
}