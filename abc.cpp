#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int ans = 0;
void check(int a, int b, int c, int arr[]){
  for(int i = 0; i < arr.size(); i++){
    if(!(arr[i] == a || arr[i] == b || arr[i] == c || arr[i] == a+b || arr[i] == a+c || arr[i] == b+c || arr[i] == a+b+c)){
      return;
    }
  }
  ans++;
}
void calc(int arr[]){
  for(int i = 0; i < 7; i++){

  }
}
int main(){
  cin >> t;
  for(int test = 0; test < t; test++){
    cin >> n;
    vector<int> arr;
    int nums[7];
    ans = 0;
    for(int i = 0; i < n; i++){
      int g;
      cin >> g;
      arr.push_back(g);
    }
    sort(arr.begin(), arr.end());
  }
}
