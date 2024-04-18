#include <bits/stdc++.h>
#include <iostream>
using namespace std;
unordered_map<int,int> a,b;
int N;
int main() {
    cin>>N;
    for(int i = 1,c,d; i<=N; i++){
        cout<<i<<" "<<i<<"\n";
        cin>>c>>d;
        a.insert({c,i});b.insert({d,i});
        if(a.count(d)!=0){
            cout<<a[d]<<" "<<i<<"\n";
            break;
        }
        else if(b.count(c)!=0){
            cout<<i<<" "<<b[c]<<"\n";
            break;
        }
    }
}