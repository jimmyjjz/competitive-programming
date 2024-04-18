#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int n,d;
    cin >> n;
    for(int i = 0; i<n; i++){
        cin >> d;
        long long a = (d-(d%3))/3, b = (d-(d%3))/3, c = (d-(d%3))/3;
        if(d%3==1)a++;
        else if(d%3==2){
            a++;
            b++;
        }
        cout << a*b*c << endl;
    }
}