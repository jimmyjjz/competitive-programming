#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int N, arr[200000][2], m=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++)cin>>arr[i][0];
    for(int i = 0; i<N; i++)cin>>arr[i][1];
    int cul=0;
    for(int i = 0; i<N; i++){
        if(arr[i][0]==1)cul++;
        else{
            if(cul!=0){
                if(cul%2==0)m+=4+(cul/2-1)*2;
                else m+=3+(cul/2)*2;
            }
            cul=0;
        }
    }
    if(cul!=0){
        if(cul%2==0)m+=4+(cul/2-1)*2;
        else m+=3+(cul/2)*2;
    }
    cul=0;
    for(int i = 0; i<N; i++){
        if(arr[i][1]==1)cul++;
        else{
            if(cul!=0){
                if(cul%2==0)m+=4+(cul/2-1)*2;
                else m+=3+(cul/2)*2;
            }
            cul=0;
        }
    }
    if(cul!=0){
        if(cul%2==0)m+=4+(cul/2-1)*2;
        else m+=3+(cul/2)*2;
    }
    for(int i = 0; i<N; i+=2)if(arr[i][0]==1&&arr[i][1]==1)m-=2;
    cout<<m<<"\n";
}