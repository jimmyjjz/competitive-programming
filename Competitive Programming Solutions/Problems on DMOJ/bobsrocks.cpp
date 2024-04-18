#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int N,in,max = 0,out=0;
    cin >> N;
    int age[51];
    for(int i = 1; i<=50; i++)age[i]=0;
    for(int i = 0; i<N; i++){
        cin >> in;
        age[in]++;
    }
    for(int i = 1; i<=50; i++){
        if(age[i]*i>max){
            max=age[i]*i;
            out=i;
        }
    }
    cout << out << endl;
}