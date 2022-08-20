#include <iostream>
#include <fstream>
#include <vector>
#include <cmath>
int n;
using namespace std;
int main(){
  ofstream fout ("cbarn.out");
  ifstream fin ("cbarn.in");
  vector<int> arr;
  fin >> n;
  for(int i = 0; i < n; i++){
    int v;
    fin >> v;
    arr.push_back(v);
  }
  int min = 2147483647;
  int total;
  for(int j = 0; j < n; j++){
    total = 0;
    for(int k = 0; k < n; k++){
      total += ((n+k-j)%n)*arr[k];
    }
    min = std::min(min, total);
  }
  fout << min << endl;
}
