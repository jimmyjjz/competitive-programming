#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int q,a,b,c,i=0,cnt=0;
    cin >> q >> a >> b >> c;
    while(q>0){
        cnt++;
        q--;
        if(i==0){
            a++;
            i++;
            if(a%35==0){
                a=0;
                q+=30;
            }
        }
        else if(i==1){
            b++;
            i++;
            if(b%100==0){
                b=0;
                q+=60;
            }
        }
        else{
            c++;
            i=0;
            if(c%10==0){
                c=0;
                q+=9;
            }
        }
    } 
    cout<<"Martha plays "<<cnt<<" times before going broke."<<endl; 
}