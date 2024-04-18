#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int N;
    cin >> N;
    if(N%2!=0&&((N-1)/2)%2!=0){
        cout<<"Yes";
        return 0;
    }
    if(N%4==0){
        cout<<"Yes";
    }
    else{
        cout << "No";
    }
}