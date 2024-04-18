#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,M;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i = 2; i<=N; i++)cout<<"1 "<<i<<"\n";
    M-=N-1;
    for(int i = 2,c=0; i<=N; i++){
        for(int j=i+1; c<M&&j<=N; j++,c++)cout<<i<<" "<<j<<"\n";
    }
}