#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int N,y,m,d;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++){
        cin>>y>>m>>d;
        if(((2007-y)>18)||((2007-y)==18&&m==1)||((2007-y)==18&&m==2&&d<=27))cout<<"Yes\n";
        else cout<<"No\n";
    }
}