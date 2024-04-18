#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
unordered_set<int> seen;
int N;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0,x; i<N; i++){
        cin>>x;
        if(seen.count(x)){
            cout<<"NO\n";
            return 0;
        }
        seen.insert(x);
    }
    cout<<"YES\n";
}