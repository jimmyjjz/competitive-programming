#include <iostream>
#include <algorithm>
#include <array>
using namespace std;
int main() {
    int q,n;
    cin >> q >> n;
    int a[n];
    int b[n];
    for(int i = 0; i<n; i++){
        int in;
        cin >> in;
        a[i]=in;
    }
    for(int i = 0; i<n; i++){
        int in;
        cin >> in;
        b[i]=in;
    }
    sort(a,a+n);
    sort(b,b+n);
    int result = 0;
    if(q==1){
        for(int i = 0; i<n; i++){
            result+=max(a[i],b[i]);
        }
    }
    else{
        int back = n-1;
        for(int i = 0; i<n; i++){
            result+=max(a[i],b[back]);
            back--;
        }
    }
    cout << result;
}