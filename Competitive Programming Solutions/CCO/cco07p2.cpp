#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N;
unordered_set<string> snowflakes;
string ori[6],rev[6];
bool exist(string cur[6]){
    for(int i = 0,tar; i<6; i++){
        string s = cur[i];
        for(int j = (i+1)%6; j!=i; j=(j+1)%6)s+=" "+cur[j];
        if(snowflakes.count(s))return true;
    }
    return false;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++){
        for(int j = 0; j<6; j++){
            cin>>ori[j];
            rev[5-j]=ori[j];
        }
        if(exist(rev)||exist(ori)){
            cout<<"Twin snowflakes found.\n";
            return 0;
        }
        snowflakes.insert(ori[0]+" "+ori[1]+" "+ori[2]+" "+ori[3]+" "+ori[4]+" "+ori[5]);
    }
    cout<<"No two snowflakes are alike.\n";
}