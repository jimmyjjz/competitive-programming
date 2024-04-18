#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int arr[5];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    arr[0]=0;
    for(int i = 1; i<5; i++){
        cin>>arr[i];
        arr[i]+=arr[i-1];
    }
    for(int i = 0; i<5; i++){
        for(int j = 0; j<5; j++)cout<<abs(arr[j]-arr[i])<<" ";
        cout<<"\n";
    }
}