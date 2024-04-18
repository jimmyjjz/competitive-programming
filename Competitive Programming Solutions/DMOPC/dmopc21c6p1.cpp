#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N;
string s;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>s;
    int swap=-1;
    for(int i = 0; i<N-1; i++){
        if((s[i]-'0')<(s[i+1]-'0')){
            swap=i;
            break;
        }
    }
    for(int i = 0; i<N; i++){
        if(swap==i)cout<<s[i+1]<<s[i++];
        else cout<<s[i];
    }
    cout<<"\n";
}