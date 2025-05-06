#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int K,v[1<<10];
vector<int> ls[10];
void dnc(int l, int r, int layer){
    if(r<l)return;
    int m = (l+r)/2;
    ls[layer].push_back(v[m]);
    dnc(l,m-1,layer+1);dnc(m+1,r,layer+1);
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>K;
    for(int i = 1; i<(1<<K); i++)cin>>v[i];
    dnc(1,(1<<K)-1,0);
    for(int i = 0; i<K; i++){
        for(int j : ls[i])cout<<j<<" ";
        cout<<"\n";
    }
}