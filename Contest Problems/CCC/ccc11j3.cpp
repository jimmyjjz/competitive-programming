#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int pre,cur,cnt=2,temp;
    cin >> pre >> cur;
    while(cur<=pre){
        temp = cur;
        cur=pre-cur;
        pre=temp;
        cnt++;
    }
    cout<<cnt;
}