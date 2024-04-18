#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N,m=0;
vector<int> v;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0,n; i<N; i++){cin>>n;v.push_back(n);}
    sort(v.begin(),v.end());
    for(int i = N-1; i>=0; i--)if(v[i]>=N-i)m=max(m,N-i);
    cout<<m<<"\n";
}