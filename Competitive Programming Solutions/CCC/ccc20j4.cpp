#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main(){
    string p,s;
    cin>>p>>s;
    int len = s.length();
    for(int i = 0; i<len; i++){
        s=s.substr(1,len)+s[0];
        if(p.find(s)!=string::npos){
            cout<<"yes";
            return 0;
        }
    }
    cout<<"no";
}