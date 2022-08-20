#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <cmath>
using namespace std;
int main(){
  ifstream fin ("hps.in");
  ofstream fout ("hps.out");
  int n;
  fin >> n;
  vector<int> arrH;
  vector<int> arrP;
  vector<int> arrS;
  arrH.push_back(0);
  arrP.push_back(0);
  arrS.push_back(0);
  for(int i = 1; i <= n; i++){
    arrH.push_back(arrH[i-1]);
    arrP.push_back(arrP[i-1]);
    arrS.push_back(arrS[i-1]);
    string s;
    fin >> s;
    if(s == "H"){arrH[i] += 1;}
    if(s == "P"){arrP[i] += 1;}
    if(s == "S"){arrS[i] += 1;}
  }
  vector<vector<int> > arr;
  arr.push_back(arrH);
  arr.push_back(arrP);
  arr.push_back(arrS);
  int m = 0;
  for(int j = 1; j <= n; j++){
    for(int a = 0; a < 3; a++){
      for(int b = 0; b < 3; b++){
        m = max(m, arr[a][j] + arr[b][n] - arr[b][j]);
      }
    }
  }
  fout << m << endl;
}
