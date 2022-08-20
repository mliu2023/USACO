#include <iostream>
#include <vector>

using namespace std;
int n;
int main(){
  cin >> n;
  vector<int> arr;
  for(int i = 0; i < n; i++){
    int x;
    cin >> x;
    arr.push_back(x%2);
  }
  int counter = 0;
  int parity = 0;
  int total = 0;
  for(int j = 0; j < n; j++){
    total += arr[j];
    if(parity == (total%2)){
      counter++;
      parity = (parity+1)%2;
      total = 0;
    }
  }
  if(total != 0){
    counter--;
  }
  cout << counter << endl;
}
