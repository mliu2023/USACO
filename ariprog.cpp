/*
ID: maximus9
TASK: ariprog
LANG: C++
*/
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
bool set[125000];
int n, m;
bool checkSequence(int a, int d){
  for(int i = 0; i < n; i++)
    if(!set[a+d*i])
      return false;
  return true;
}
int main() {
    ofstream fout ("ariprog.out");
    ifstream fin ("ariprog.in");
    fin >> n >> m;
    for(int i = 0; i <= m; i++)
      for(int j = 0; j <= i; j++)
        set[i*i+j*j]=true;
    bool x = true;
    for(int d = 1; d <= 2*m*m; d++){
      for(int a = 0; a+d*(n-1) <= 2*m*m; a++){
        if(checkSequence(a, d)){
          fout << a << " " << d << endl;
          x=false;
        }
      }
    }
    if(x){
      fout << "NONE" << endl;
    }
    return 0;
}
