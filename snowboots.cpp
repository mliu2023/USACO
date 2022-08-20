#include <iostream>
#include <fstream>

#define MAXN 250

using namespace std;

int main(){
  ifstream fin ("snowboots.in");
  ofstream fout ("snowboots.out");
  int n, b;
  fin >> n >> b;
  int depthArr[n];
  pair<int, int> bootsArr[b];
  for(int i = 0; i < n; i++){
    fin >> depthArr[i];
  }
  for(int j = 0; j < b; j++){
    int n1, n2;
    fin >> n1 >> n2;
    bootsArr[j] = pair<int, int>(n1, n2);
  }
  int currBoots = 0;
  int k = 0;
  while(k < n-1){
    bool jumped = false;
    for(int l = min(n-1, k+bootsArr[currBoots].second); l > k; l--){
      if(bootsArr[currBoots].first >= depthArr[l]){
        k = l;
        jumped = true;
        break;
      }
    }
    if(!jumped){
      currBoots++;
    }
  }
  while(bootsArr[currBoots].first == 0){
    currBoots++;
  }
  fout << currBoots << endl;
  fout.close();
}
