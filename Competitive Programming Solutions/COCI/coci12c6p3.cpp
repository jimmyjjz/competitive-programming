#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N, A[5000], cnt=0;
unordered_set<int> s;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++){
        cin>>A[i];
        for(int j = i-1; j>=0; j--){
            if(s.count(A[i]-A[j])){
                cnt++;
                break;
            }
        }
        for(int j = i; j>=0; j--)s.insert(A[i]+A[j]);
    }
    cout<<cnt<<"\n";
}