#include <bits/stdc++.h>
#include <iostream>
using namespace std;
long long n,k,m,cnt=0,x;
map<long long,int> idx;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>n>>k>>m;
    for(int i = 0; i<n; i++){
        cin>>x;
        idx[x]=i;
    }
    for(int i = 0; i<n; i++){
        cin>>x;
        if(idx.count(m-x)&&abs(i-idx[m-x])>=k)cnt++;
    }
    cout<<cnt<<"\n";
}