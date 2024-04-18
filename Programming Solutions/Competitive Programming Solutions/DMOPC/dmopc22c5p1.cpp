#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
ll N,m=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; N>1; i++,N-=2)m=max(m,max(0LL,N*(N-1)/2)*i);
    cout<<m<<"\n";
}