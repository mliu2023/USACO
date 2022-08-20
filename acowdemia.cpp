#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
vector<int> arr;
long n, k, l;

bool check(int x){
  long totalRating = 0;
  for(int i = n-1; i >= n-x; i--){
    if(arr[i] + k < x){
      return false;
    }
    if(arr[i] < x){
      totalRating += (x - arr[i]);
    }
  }
  return totalRating <= (long)(k*l);
}
int main(){
  cin >> n >> k >> l;
  for(int i = 0; i < n; i++){
    int g;
    cin >> g;
    arr.push_back(g);
  }
  sort(arr.begin(), arr.end());
  int lo = 0;
  int hi = n;
  for(--lo; lo < hi;){
    int mid = (lo+hi+1)/2;
    if(check(mid)){
      lo = mid;
    }
    else{
       hi = mid-1;
    }
  }
  cout << lo << endl;
}
