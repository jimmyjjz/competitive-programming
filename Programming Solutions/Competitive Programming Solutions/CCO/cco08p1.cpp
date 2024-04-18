#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N, status[101]={0}, moving[101]={0};
bool visited[101];
string names[101];
vector<string> o;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    string a;
    for(int i = 0,b,c; i<N; i++){
        cin>>a>>b>>c;
        names[c]=a;
        moving[c]=b;
        status[b]=2;
        status[c]=max(1,status[c]);
    }
    for(int i = 1; i<=100; i++){
        if(status[i]!=1)continue;
        int n = i;
        visited[n]=true;
        o.push_back(names[n]);
        while(moving[n]!=0){n=moving[n];visited[n]=true;o.push_back(names[n]);}
    }
    for(int i = 1; i<=100; i++){
        if(!visited[i]&&status[i]!=0){
            cout<<"Impossible\n";
            return 0;
        }
    }
    for(string s : o)cout<<s<<"\n";
}