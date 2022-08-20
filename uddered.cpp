#include <iostream>
#include <string>

using namespace std;

string alphabet;

int indexOf(char s){
  for(int i = 0; i < 26; i++){
    if(alphabet[i] == s){
      return i;
    }
  }
  return -1;
}
int main(){
  string str;
  cin >> alphabet;
  cin >> str;
  int counter = 1;
  for(int i = 1; i < str.length(); i++){
    if(indexOf(str[i]) <= indexOf(str[i-1])){
      counter++;
    }
  }
  cout << counter << endl;
}
