#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,K,lens[300000],inRange[21]={0};
long long pairs=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>K;
    string s;
    for(int i = 0; i<N; i++){
        cin>>s;
        lens[i]=s.length();
    }
    for(int i = 0; i<K; i++)inRange[lens[i]]++;
    for(int i = 0; i<N; i++){
        inRange[lens[i]]--;
        if(i+K<N)inRange[lens[i+K]]++;
        pairs+=inRange[lens[i]];
    }
    cout<<pairs<<"\n";
}