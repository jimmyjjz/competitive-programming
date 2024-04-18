#include <string>
#include <iostream>
using namespace std;
bool check(string s){
    string temp = "";
    for(int i = 0; i<s.length(); i++){
        if(temp.find(s[i])!=string::npos){
            return true;
        }
        temp+=s[i];
    }
    return false;
}
int main() {
    int year;
    cin >> year;
    year++;
    string s = to_string(year);
    while(check(s)){
        year++;
        s=to_string(year);
    }
    cout << s;
}