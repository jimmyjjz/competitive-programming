#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N, cnt = 0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0,a; i<N; i++){
        cin>>a;
        cnt+=(a%2==i%2)?1:0;
    }
    cout<<cnt;
}