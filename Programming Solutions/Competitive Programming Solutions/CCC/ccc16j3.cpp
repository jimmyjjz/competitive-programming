#include <bits/stdc++.h>
#include <iostream>
using namespace std;
string rev(string s){
    return string(s.rbegin(),s.rend());
}
int main() {
    string s;
    cin >> s;
    int len = s.length(), m = 1;
    for(int i  = 0; i<len; i++){
        for(int j = 2; i+j<=len; j++){
            if(s.substr(i,j)==rev(s.substr(i,j))){
                m=max(m,j);
        }
    }
}
cout << m;
}