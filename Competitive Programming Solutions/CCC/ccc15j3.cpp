#include <bits/stdc++.h>
#include <iostream>
using namespace std;
bool vowel(char c){
    return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
}
int main() {
    string s;
    cin >> s;
    for(char c : s){
      cout<<c;
      if(vowel(c))continue;
      int dex = 1;
      while(true){
          if((c-97-dex)>=0&&vowel((char)(c-dex))){
              cout<<(char)(c-dex);
              break;
          }
          if((c-97+dex)<26&&vowel((char)(c+dex))){
              cout<<(char)(c+dex);
              break;
          }
          dex++;
      }
      if(c-97==25){
          cout<<'z';
          continue;
      }
      for(int i = c-97+1; i<26; i++){
          if(!vowel((char)(i+97))){
              cout<<(char)(i+97);
              break;
          }
      }
    }
}