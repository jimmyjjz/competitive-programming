#include <string>
#include <iostream>
using namespace std;
int main() {
    int n;
    cin >> n;
    for(int i = 0; i<n; i++){
        string s;
        cin >> s;
        int con = 0;
        char pre = s[0];
        for(char c : s){
            if(c!=pre){
                cout << con << " " << pre << " ";
                con = 0;
                pre = c;
            }
            con++;
        }
        cout << con << " " << pre << endl;
    }
}