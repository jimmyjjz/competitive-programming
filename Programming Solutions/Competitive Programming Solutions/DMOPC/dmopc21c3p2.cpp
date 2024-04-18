#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
unordered_map<ll,int> m;
ll K;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>K;
    if(K==0){
        cout<<"1\n1\n";
        return 0;
    }
    for(ll i = 1; i<=1000000; i++)m.insert({(((i+1)*i)/2),i});
    if(m.count(K)){
        cout<<m[K]<<"\n0";
        for(int i = 1; i<m[K]; i++)cout<<" 0";
    }
    else{
        for(ll i = 1; i<=1000000; i++){
            if(K>(((i+1)*i)/2)&&m.count(K-(((i+1)*i)/2))&&i+1+m[K-(((i+1)*i)/2)]<=1000000){
                cout<<(i+1+m[K-(((i+1)*i)/2)])<<"\n";
                for(int j = 0; j<i; j++)cout<<"0 ";
                cout<<"1";
                for(int j = 0; j<m[K-(((i+1)*i)/2)]; j++)cout<<" 0";
                cout<<"\n";
                return 0;
            }
        }
        cout<<"-1";
    }
    cout<<"\n";
}