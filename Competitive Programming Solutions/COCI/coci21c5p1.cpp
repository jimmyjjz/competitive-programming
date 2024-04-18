#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
bool ans(string s){
    s+="1";
    int a[26]={}, b[26]={}, len=s.length();
    bool check = true, next=false;
    for(int i = 0,coeff; i<len; i++){
        if(check){
            if(s[i]-'A'<0)coeff=s[i]-'0';
            else coeff=1;
            check=false;
        }
        if(s[i]=='+')check=true;
        else if(s[i]=='-'){
            i++;
            check=true;
            next=true;
        }
        else if(s[i]-'A'>=0){
            if(next)b[s[i]-'A']+=(s[i+1]-'A'<0&&s[i+1]!='+'&&s[i+1]!='-')?coeff*(s[i+1]-'0'):coeff;
            else a[s[i]-'A']+=(s[i+1]-'A'<0&&s[i+1]!='+'&&s[i+1]!='-')?coeff*(s[i+1]-'0'):coeff;
        }
    }
    for(int i = 0; i<26; i++)if(a[i]!=b[i])return false;
    return true;
}
int N;
string in;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++){
        cin>>in;
        cout<<(ans(in)?"DA\n":"NE\n");
    }
}