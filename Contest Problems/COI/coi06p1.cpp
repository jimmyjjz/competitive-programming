#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N;
ll cnt=0;
vector<int> v;
int bsearch(int n){
    int l = 0, h = v.size()-1;
    while(l<=h){
        int m=(l+h)/2;
        if(v[m]>n)l=m+1;
        else h=m-1;
    }
    if(h+1!=0)return h;
    return h+1;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0,x; i<N; i++){
        cin>>x;
        cnt+=v.size()-bsearch(x);
        while(!v.empty()&&v.back()<x)v.pop_back();
        v.push_back(x);
    }
    cout<<cnt<<"\n";
}