#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int n,in;
    vector<int> pre;
    cin >> n >> in;
    pre.push_back(in);
    for(int i = 2; i<=n; i++){
        vector<int> now;
        for(int j = 0; j<i; j++){
            int a;
            cin >> a;
            now.push_back(a);
        }
        now[0]+=pre[0];
        now[i-1]+=pre[i-2];
        for(int j = 1; j<i-1; j++){
            now[j]+=max(pre[j-1],pre[j]);
        }
        pre=now;
    }
    int m = 0;
    for(int i = 0; i<n; i++){
        m=max(m,pre[i]);
    }
    cout << m;
}