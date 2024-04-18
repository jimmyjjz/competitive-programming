#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int N;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    if(N<4)cout<<"0\n";
    else cout<<((N-1)*(N-2)*(N-3))/6<<"\n";
}