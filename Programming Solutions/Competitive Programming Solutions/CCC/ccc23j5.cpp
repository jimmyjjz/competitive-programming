#include <bits/stdc++.h>
#include <iostream>
using namespace std;
string w;
int n,m,cnt=0;
string board[100][100];
void find(int r, int c, bool turned, string cul, int d){
    if(r>=n||c>=m||r<0||c<0||cul.length()>=w.length())return;
    cul+=board[r][c];
    if(cul==w){
        cnt++;
        //cout<<cul<<" "<<d<<" "<<r<<" "<<c<<"|||";
        return;
    }
    if(d==0){
        find(r,c+1,turned,cul,d);
        if(!turned){
            find(r-1,c,true,cul,2);
            find(r+1,c,true,cul,6);
        }
    }
    else if(d==1){
        find(r-1,c+1,turned,cul,d);
        if(!turned){
            find(r-1,c-1,true,cul,3);
            find(r+1,c+1,true,cul,7);
        }
    }
    else if(d==2){
        find(r-1,c,turned,cul,d);
        if(!turned){
            find(r,c-1,true,cul,4);
            find(r,c+1,true,cul,0);
        }
    }
    else if(d==3){
        find(r-1,c-1,turned,cul,d);
        if(!turned){
            find(r+1,c-1,true,cul,5);
            find(r-1,c+1,true,cul,1);
        }
    }
    else if(d==4){
        find(r,c-1,turned,cul,d);
        if(!turned){
            find(r+1,c,true,cul,6);
            find(r-1,c,true,cul,2);
        }
    }
    else if(d==5){
        find(r+1,c-1,turned,cul,d);
        if(!turned){
            find(r+1,c+1,true,cul,7);
            find(r-1,c-1,true,cul,3);
        }
    }
    else if(d==6){
        find(r+1,c,turned,cul,d);
        if(!turned){
            find(r,c+1,true,cul,0);
            find(r,c-1,true,cul,4);
        }
    }
    else if(d==7){
        find(r+1,c+1,turned,cul,d);
        if(!turned){
            find(r-1,c+1,true,cul,1);
            find(r+1,c-1,true,cul,5);
        }
    }
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>w>>n>>m;
    for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++)cin>>board[i][j];
    }
    for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            find(i,j+1,false,board[i][j],0);
            find(i-1,j+1,false,board[i][j],1);
            find(i-1,j,false,board[i][j],2);
            find(i-1,j-1,false,board[i][j],3);
            find(i,j-1,false,board[i][j],4);
            find(i+1,j-1,false,board[i][j],5);
            find(i+1,j,false,board[i][j],6);
            find(i+1,j+1,false,board[i][j],7);
        }
    }
    cout<<cnt;
}