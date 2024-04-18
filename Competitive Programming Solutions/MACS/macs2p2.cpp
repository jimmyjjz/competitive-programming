#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,M,cnt[61881]={0};
void make(int hash, int p){
    if(p==0){
        cnt[hash]++;
        return;
    }
    for(int i = 0; i<26; i++)make(hash*13+i+1,p-1);
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    make(0,N);
    cout<<cnt[M]<<"\n";
}