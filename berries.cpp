#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
using namespace std;

int n, k;
int mod;

bool cmp(int a, int b){
  return (a%mod > b%mod);
}
int main(){
  ifstream fin ("berries.in");
  ofstream fout ("berries.out");
  fin >> n >> k;
  int m = 0;
  vector<int> arr;
  for(int i = 0; i < n; i++){
    int bi;
    fin >> bi;
    m = max(m, bi);
    arr.push_back(bi);
  }
  int best = 0;
  for(int b = 1; b <= m; b++){
    int full = 0;
    for(int i = 0; i < n; i++){
      full += arr[i]/b;
    }
    if(full < k/2){
      break;
    }
    if(full >= k){
      best = max(best, b*(k/2));
      continue;
    }
    mod = b;
    sort(arr.begin(), arr.end(), cmp);
    int cur = b*(full-k/2);
    for(int i = 0; i < n && i + full < k; i++){
      cur += arr[i]%b;
    }
    best = max(best, cur);
  }
  fout << best << endl;
}
