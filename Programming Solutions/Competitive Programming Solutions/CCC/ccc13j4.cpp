#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int t,n;
    cin >> t >> n;
    vector<int> c;
    for(int i = 0; i<n; i++){
        int in;
        cin >> in;
        c.push_back(in);
    }
    sort(c.begin(), c.end());
    int cnt = 0;
    for(int i : c){
        if(t-i<0)break;
        cnt++;
        t-=i;
    }
    cout << cnt;
}