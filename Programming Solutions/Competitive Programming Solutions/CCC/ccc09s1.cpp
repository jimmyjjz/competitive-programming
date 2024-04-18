#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll a,b;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>a>>b;
    ll n=1,cnt=0;
    while((n*n)*(n*n)*(n*n)<a)n++;
    while((n*n)*(n*n)*(n*n)<=b){
        cnt++;
        n++;
    }
    cout<<cnt<<"\n";
}