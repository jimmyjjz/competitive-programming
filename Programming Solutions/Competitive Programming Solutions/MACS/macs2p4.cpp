#include <bits/stdc++.h>
#include <iostream>
using namespace std;
string R;
long long D,dp[19][2][19][10][19];
int digits[19],d;
long long r(int i, bool cap, int c, int pre, int best){
    if(i==d)return max(c,best)>=D;
    if(pre!=-1&&dp[i][cap][c][pre][best]!=-1)return dp[i][cap][c][pre][best];
    long long res=0;
    for(int j = 0; j<=(cap?digits[i]:9); j++)res+=r(i+1,cap&&j==digits[i],j==pre?c+1:1,pre==-1&&j==0?-1:j,max(best,c));
    dp[i][cap][c][pre][best]=res;
    return res;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>R>>D;
    d=R.length();
    for(int i1 = 0; i1<19; i1++)
        for(int i2 = 0; i2<2; i2++)
            for(int i3 = 0; i3<19; i3++)
                for(int i4 = 0; i4<10; i4++)
                    for(int i5 = 0; i5<19; i5++)dp[i1][i2][i3][i4][i5]=-1;
    for(int i = 0; i<d; i++)digits[i]=R[i]-'0';
    if(D==1)cout<<r(0,true,0,-1,0)-1<<"\n";
    else cout<<r(0,true,0,-1,0)<<"\n";
}