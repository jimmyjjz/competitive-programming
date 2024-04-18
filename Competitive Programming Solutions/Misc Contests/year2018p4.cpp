#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
ll L,R,SR=0,cnt=0;
bool lowerAndCheck(string s, ll i){
    ll change=-i;
    for(char c : s)change+=c-'0';
    if(change<0)return false;
    for(ll j = s.length()-1; change!=0&&j>=0; j--){
        if(s[j]-'0'>change){
            s[j]=(char)(s[j]-change);
            change=0;
        }
        else{
            change-=s[j]-'0';
            s[j]='0';
        }
    }
    if(change!=0||stoll(s)<L)return false;
    return true;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>L>>R;
    string s = to_string(R);
    for(char c : s)SR+=c-'0';
    for(ll i = 0; i<=9*18; i++){
        if(SR==i)cnt++;
        else if(SR>i){
            if(lowerAndCheck(s,i))cnt++;
        }
        else{
            for(ll j = 0; j<s.length(); j++){
                string t = s;
                if(t[j]-'0'==0)continue;
                t[j]=(char)(t[j]-1);
                for(ll k = j+1; k<s.length(); k++)t[k]='9';
                if(lowerAndCheck(t,i)){
                    cnt++;
                    break;
                }
            }
        }
    }
    cout<<cnt<<"\n";
}