#include <bits/stdc++.h>
#include <iostream>
using namespace std;
char c;
int l,r;
void shiftR(){
    if(c=='S')c='W';
    else if(c=='W')c='N';
    else if(c=='N')c='E';
    else c='S';
}
void shiftL(){
    if(c=='S')c='E';
    else if(c=='E')c='N';
    else if(c=='N')c='W';
    else c='S';
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>c>>l>>r;
    l%=4;
    r%=4;
    for(int i = 0; i<r; i++)shiftR();
    for(int i = 0; i<l; i++)shiftL();
    cout<<c<<"\n";
}