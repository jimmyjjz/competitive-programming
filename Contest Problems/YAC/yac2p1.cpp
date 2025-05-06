#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int T;
long long a,b,c,d;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>T;
    for(int i = 0; i<T; i++){
        cin>>a>>b>>c>>d;
        cout<<(((d-c)*(b-a)>c*a)?"YES":"NO")<<"\n";
    }
}