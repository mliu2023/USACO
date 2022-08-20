#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>

using namespace std;

vector<string> cows, beside_a, beside_b;
int n;

int indexOf(string s){
  for(int i = 0; i < 8; i++){
    if(cows[i]==s){
      return i;
    }
  }
  return -1;
}

bool isValid(){
  for(int i = 0; i < n; i++){
    if(abs(indexOf(beside_a[i])-indexOf(beside_b[i])) != 1){
      return false;
    }
  }
  return true;
}

int main(){
  ifstream fin ("lineup.in");
  ofstream fout ("lineup.out");
  fin >> n;
  cows.push_back("Beatrice");
  cows.push_back("Belinda");
  cows.push_back("Bella");
  cows.push_back("Bessie");
  cows.push_back("Betsy");
  cows.push_back("Blue");
  cows.push_back("Buttercup");
  cows.push_back("Sue");
  for(int i = 0; i < n; i++){
    string a, b, t;
    fin >> a;
    fin >> t;
    fin >> t;
    fin >> t;
    fin >> t;
    fin >> b;
    beside_a.push_back(b);
    beside_b.push_back(a);
  }
  do{
    if(isValid()){
      for(int l = 0; l < 8; l++){
        fout << cows[l] << endl;
      }
      break;
    }
  }
  while(next_permutation(cows.begin(), cows.end()));
}
