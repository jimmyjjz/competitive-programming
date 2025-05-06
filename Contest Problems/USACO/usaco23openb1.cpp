#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N, mi=0, ma=0,i=0,l,r;
string s;
bool edge=false;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>s;
    if(s[0]=='F'){
        edge=true;
        for(; i<N; i++)if(s[i]=='F')ma++;else break;
    }
    l=i;r=i;
    for(; i<N; i++){
        if(s[i]!='F'){
            l=r;
            r=i;
            if((r-l-1)==0){
                if(s[l]==s[r]){
                    mi++;
                    ma++;
                }
            }
            else if((r-l-1)%2==1&&s[l]==s[r])ma+=r-l;
            else if((r-l-1)%2==0&&s[l]!=s[r])ma+=r-l-1;
            else if((r-l-1)%2==1&&s[l]!=s[r]){mi++;ma+=r-l-1;}
            else if(((r-l-1)%2==0&&s[l]==s[r])){mi++;ma+=r-l;}
        }
    }
    if(s[N-1]=='F'){
        edge=true;
        ma+=N-r-1;
    }
    if(edge){
        cout<<(ma-mi+1)<<"\n";
        for(int i = mi; i<=ma; i++)cout<<i<<"\n";
    }
    else{
        cout<<(ma-mi)/2+1<<"\n";
        for(int i = mi; i<=ma; i+=2)cout<<i<<"\n";
    }
}