#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
long long N,sum=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 1; i<=sqrt(N); i++){
        if(N%i==0&&(N-i)/i!=0&&N/((N-i)/i)==N%((N-i)/i))sum+=((N-i)/i);
    }
    cout<<sum<<"\n";
}