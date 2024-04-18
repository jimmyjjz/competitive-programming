#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
string s;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>s;
    if(s.length()%2==0){
        cout<<"NOT POSSIBLE\n";
        return 0;
    }
    int orilen=s.length()/2;
    if(s.substr(1,orilen)==s.substr(orilen+1,orilen)){
        if(s.substr(1,orilen)==s.substr(orilen+1,orilen)&&s.substr(0,orilen)==s.substr(orilen,orilen)&&s.substr(0,orilen)!=s.substr(1,orilen))cout<<"NOT UNIQUE\n";
        else cout<<s.substr(1,orilen)<<"\n";
        return 0;
    }
    string o=s.substr(0,1);
    bool used = false;
    if(s[0]==s[orilen]){
        for(int i = 1; i<orilen; i++){
            if(s[i]==s[i+orilen+used])o+=s[i];
            else if(!used){
                used=true;
                i--;
            }
            else{
                cout<<"NOT POSSIBLE\n";
                return 0;
            }
        }
    }
    else if(s[0]==s[orilen+1]){
        for(int i = 1; i<orilen; i++){
            if(s[i+used]==s[i+orilen+1])o+=s[i+used];
            else if(!used){
                used=true;
                i--;
            }
            else{
                cout<<"NOT POSSIBLE\n";
                return 0;
            }
        }
    }
    else{
        cout<<"NOT POSSIBLE\n";
        return 0;
    }
    cout<<o<<"\n";
}