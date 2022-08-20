#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
  ifstream fin ("haybales.in");
  ofstream fout ("haybales.out");
  int n, q;
  fin >> n >> q;
  vector<int> arr;
  for(int i = 0; i < n; i++){
    int x;
    fin >> x;
    arr.push_back(x);
  }
  sort(arr.begin(), arr.end());
  vector<int>::iterator lower, upper;
  for(int j = 0; j < q; j++){
    int a, b;
    fin >> a >> b;
    upper = upper_bound(arr.begin(), arr.end(), b);
    lower = lower_bound(arr.begin(), arr.end(), a);
    fout << upper-lower << endl;
  }
}
