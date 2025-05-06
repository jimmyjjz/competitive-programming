#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int C,N,dif[1<<18],n[100000];
string str;
int closest(int x){
    if(dif[x]==-2){
        dif[x]=-1;
        for(int i = 0; i<C; i++){
            if(dif[x^(1<<i)]==-1)continue;
            if(dif[x]==-1)dif[x]=closest(x^(1<<i))+1;
            else dif[x]=min(dif[x],closest(x^(1<<i))+1);
        }
    }
    return dif[x];
}
int toBit(string s){
    int out = 0;
    for(int i = 0; i<C; i++)if(s[i]=='G')out|=(1<<i);
    return out;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>C>>N;
    for(int i = 0; i<(1<<C); i++)dif[i]=-2;
    for(int i = 0; i<N; i++){cin>>str;n[i]=toBit(str);dif[n[i]^((1<<C)-1)]=0;}
    for(int i = 0; i<N; i++)cout<<(C-closest(n[i]))<<"\n";
}