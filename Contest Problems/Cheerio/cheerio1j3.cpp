#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,cnt[1501]={0};
string s;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++){
        cin>>s;
        for(int j = 0; j<N; j++)cnt[j]+=s[j]=='S';
    }
    for(int i = N; i>=1; i--){
        for(int j = 0; j<N; j++)cout<<(cnt[j]<i?".":"S");
        cout<<"\n";
    }
}