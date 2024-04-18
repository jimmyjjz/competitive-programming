#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int R,C,arr[100][100],m=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>R>>C;
    for(int i = 0; i<R; i++)for(int j = 0; j<C; j++)cin>>arr[i][j];
    for(int i = 0; i<R; i++)for(int j = 0; j<C; j++)
        if(i>0&&arr[i-1][j]==arr[i][j])m=max(m,arr[i][j]);
        else if(i>0&&j>0&&arr[i-1][j-1]==arr[i][j])m=max(m,arr[i][j]);
        else if(i>0&&j<C-1&&arr[i-1][j+1]==arr[i][j])m=max(m,arr[i][j]);
        else if(i<R-1&&arr[i+1][j]==arr[i][j])m=max(m,arr[i][j]);
        else if(i<R-1&&j>0&&arr[i+1][j-1]==arr[i][j])m=max(m,arr[i][j]);
        else if(i<R-1&&j<C-1&&arr[i+1][j+1]==arr[i][j])m=max(m,arr[i][j]);
        else if(j>0&&arr[i][j-1]==arr[i][j])m=max(m,arr[i][j]);
        else if(j<C-1&&arr[i][j-1]==arr[i][j])m=max(m,arr[i][j]);
    cout<<m<<"\n";
}