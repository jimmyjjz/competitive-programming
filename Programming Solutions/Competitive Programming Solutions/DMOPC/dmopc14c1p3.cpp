#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int I,S;
ll total = 0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>I;
    for(int i = 0,x; i<I; i++){
        cin>>x;
        total+=x;
    }
    cin>>S;
    for(int i = 1,x; i<=S; i++){
        cin>>x;
        total+=x;
        cout<<total/(double)(I+i)<<"\n";
    }
}