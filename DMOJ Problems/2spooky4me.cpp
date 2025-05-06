#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct triple{int a,b,c;};
int N,L,S,Asize,Bsize,presum[60010],total=0;
map<int,int> compression;
unordered_set<int> removeDupe,add;
vector<int> sortedA,sortedB;
triple offline[10000];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>L>>S;
    for(int i = 0,a,b,c; i<N; i++){
        cin>>a>>b>>c;
        offline[i]={a,b,c};
        removeDupe.insert(a);
        removeDupe.insert(b);
        add.insert(a);
        add.insert(b);
        add.insert(a-1);
        add.insert(b-1);
        add.insert(a+1);
        add.insert(b+1);
    }
    removeDupe.insert(1);
    removeDupe.insert(L);
    add.insert(1);
    add.insert(L);
    add.insert(0);
    add.insert(2);
    add.insert(L-1);
    add.insert(L+1);
    for(int i : removeDupe)sortedA.push_back(i);
    sort(sortedA.begin(),sortedA.end());
    for(int i : add)sortedB.push_back(i);
    sort(sortedB.begin(),sortedB.end());
    Bsize=sortedB.size();
    Asize=sortedA.size();
    for(int i = 0; i<Bsize; i++)compression[sortedB[i]]=i;
    for(int i = 0; i<N; i++){
        presum[compression[offline[i].a]]+=offline[i].c;
        presum[compression[offline[i].b+1]]-=offline[i].c;
    }
    for(int i = 1; i<Bsize; i++)presum[i]+=presum[i-1];
    if(presum[compression[sortedA[0]]]<S)total++;
    for(int i = 0; i<Asize-1; i++){
        if(presum[compression[sortedA[i+1]]-1]<S)total+=sortedA[i+1]-sortedA[i]-1;
        if(presum[compression[sortedA[i+1]]]<S)total++;
    }
    cout<<total<<"\n";
}