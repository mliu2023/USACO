#include <iostream>
#include <fstream>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
int n, b;
int main(){
  ofstream fout ("balancing.out");
  ifstream fin ("balancing.in");
  fin >> n >> b;
  vector<int> xArr;
  vector<int> yArr;
  vector<int> xArr2;
  vector<int> yArr2;
  for(int i = 0; i < n; i++){
    int x, y;
    fin >> x >> y;
    xArr.push_back(x);
    yArr.push_back(y);
    xArr2.push_back(x);
    yArr2.push_back(y);
  }
  sort(xArr2.begin(), xArr2.end());
  sort(yArr2.begin(), yArr2.end());
  int min = 2147483647;
  for(int r = 0; r < n; r++){
    for(int c = 0; c < n; c++){
      int a = xArr2[r]+1;
      int b = yArr2[c]+1;
      int q1 = 0;
      int q2 = 0;
      int q3 = 0;
      int q4 = 0;
      for(int r1 = 0; r1 < n; r1++){
        if(xArr[r1] > a && yArr[r1] > b){
          q1++;
        }
        else if(xArr[r1] > a && yArr[r1] < b){
          q4++;
        }
        else if(xArr[r1] < a && yArr[r1] < b){
          q3++;
        }
        else{
          q2++;
        }
      }
      int g = std::max(q1, q2);
      int h = std::max(q3, q4);
      int k = std::max(g,h);
      min = std::min(min, k);
    }
  }
  fout << min << endl;
}
