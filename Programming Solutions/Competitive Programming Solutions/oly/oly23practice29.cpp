#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N,m=INT_MAX,cnt=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0,x; i<N; i++){
        cin>>x;
        if(x<m)cnt++;
        m=min(m,x);
    }
    cout<<cnt<<"\n";
}