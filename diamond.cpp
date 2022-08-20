#include <iostream>
#include <fstream>
#include <array>

using namespace std;

int main(){
  ifstream fin ("diamond.in");
  ofstream fout ("diamond.out");
  int n, k;
  fin >> n >> k;
  int arr[10000] = { };
  for(int i = 0; i < n; i++){
    int val;
    fin >> val;
    arr[val]++;
  }
  for(int j = 1; j < 10000; j++){
    arr[j] += arr[j-1];
  }
  int max = 0;
  for(int l = k+1; l < 10000; l++){
    if(arr[l] - arr[l-k-1] > max){
      max = arr[l] - arr[l-k-1];
    }
  }
  fout << max << endl;
}
