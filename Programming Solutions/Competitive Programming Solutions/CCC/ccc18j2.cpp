#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int N,cnt=0;
string a,b;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>a>>b;
    for(int i = 0; i<N; i++)if(a[i]=='C'&&b[i]=='C')cnt++;
    cout<<cnt<<"\n";
}