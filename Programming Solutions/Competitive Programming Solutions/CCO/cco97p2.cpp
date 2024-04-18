#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int T;
vector<int> guns;
int bsearch(int n){
    int l = 0, h = guns.size()-1;
    while(l<=h){
        int m = (l+h)/2;
        if(guns[m]>n)h=m-1;
        else if(guns[m]==n)return m;
        else l=m+1;
    }
    return h+1;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>T;
    for(int i = 0,N; i<T; i++){
        cin>>N;
        guns.clear(); guns.push_back(INT_MAX);
        for(int j = 0,x; j<N; j++){
            cin>>x;
            if(x>guns.back())guns.push_back(INT_MAX);
            guns[bsearch(x)]=x;
        }
        cout<<guns.size()<<"\n";
    }
}