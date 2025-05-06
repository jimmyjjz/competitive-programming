#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct p{int a,b;};
struct trip{int a,b,c;};
struct vs{int arr[41]={0};};
bool cmp(p a, p b){return a.a<b.a;}
unordered_map<int,int> compression;
unordered_map<int,vs> store[1048576]; 
p instructions[40];
vector<trip> fh,sh;
long long fre[41]={0};
int N,tx,ty;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>tx>>ty;
    for(int i = 0,a,b; i<N; i++){
        cin>>a>>b;
        instructions[i]={a,b};
    }
    int fhv=1<<(N/2),amount=N/2;
    for(int i = 0,m,x,y; i<fhv; i++){
        m=0;x=0;y=0;
        for(int j = 0; j<amount; j++){
            if(i&(1<<j)){
                m++;
                x+=instructions[j].a;
                y+=instructions[j].b;
            }
        }
        fh.push_back({x,y,m});
    }
    if(N%2){
        fhv=1<<(N/2+1);
        amount++;
    }
    for(int i = 0,m,x,y; i<fhv; i++){
        m=0;x=0;y=0;
        for(int j = 0; j<amount; j++){
            if(i&(1<<j)){
                m++;
                x+=instructions[j+N/2].a;
                y+=instructions[j+N/2].b;
            }
        }
        sh.push_back({x,y,m});
    }
    int shsize=sh.size(), idx=0;
    for(int i = 0; i<shsize; i++){
        if(compression.count(sh[i].a)==0){
            compression.insert({sh[i].a,idx});
            idx++;
        }
        if(store[compression[sh[i].a]].count(sh[i].b)==0){
            vs temp;
            store[compression[sh[i].a]].insert({sh[i].b,temp});
        }
        store[compression[sh[i].a]][sh[i].b].arr[sh[i].c]++;
    }
    int fhsize=fh.size();
    for(int i = 0; i<fhsize; i++){
        if(compression.count(tx-fh[i].a)==0)continue;
        int m,point=compression[tx-fh[i].a],temp=store[compression[tx-fh[i].a]].size()-1,h=temp,l=0,tar=ty-fh[i].b;
        if(store[point].count(tar)==0)continue;
        for(int j = 0; j<41; j++)fre[j+fh[i].c]+=store[point][tar].arr[j];
    }
    for(int i = 1; i<=N; i++)cout<<fre[i]<<"\n";
}