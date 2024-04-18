#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,m=0,n[100000],r=10;
string s;
bool cmp(int a, int b){return a%r<b%r;}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++){
        cin>>n[i];
        s=to_string(n[i]);
        m=max(m,(int)s.length());
    }
    for(int i = 0; i<m; r*=10,i++){
        sort(n,n+N,cmp);
        cout<<n[0];
        for(int j = 1; j<N; j++)cout<<" "<<n[j];
        cout<<"\n";
    }
}