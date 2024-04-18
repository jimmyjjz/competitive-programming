#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int N,D,cur,found=-1;
    cin >> N >> D;
    for(int i = 0; i<N; i++){
        cin >> cur;
        if(D%cur==0&&D/cur){
            if(found==-1)found=abs(D/cur);
            else found=min(found,abs(D/cur));
    }
}
    if(found==-1)cout<<"This is not the best time for a trip."<<endl;
    else cout<<found<<endl;
}