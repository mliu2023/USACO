#include <iostream>
#include <fstream>
#include <vector>
using namespace std;
int main(){
  ifstream fin ("maxcross.in");
  ofstream fout ("maxcross.out");
  int n, k, b;
  fin >> n >> k >> b;
  vector<int> arr(n+1, 0);
  for(int i = 0; i < b; i++){
    int x;
    fin >> x;
    arr[x] = 1;
  }
  vector<int> cu;
  cu.push_back(arr[0]);
  for(int h = 1; h < k; h++){
    cu.push_back(cu[h-1]+arr[h]);
  }
  for(int j = k; j <= n; j++){
    cu.push_back(cu[j-1]-arr[j-k]);
    if(arr[j] == 1){
      cu[j] += 1;
    }
  }
  int m = 100000;
  for(int l = k; l <= n; l++){
    m = min(m, cu[l]);
  }
  fout << m << endl;
}
