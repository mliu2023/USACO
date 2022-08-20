#include <iostream>
#include <fstream>
#include <vector>
#include <unordered_set>
#include <string>
#include <algorithm>

using namespace std;

int compare(unordered_set<string> a, unordered_set<string> b){
  int aSize = a.size();
  int bSize = b.size();
  a.insert(b.begin(), b.end());
  int abSize = a.size();
  return aSize+bSize-abSize;
}

int main(){
  ifstream fin ("guess.in");
  ofstream fout ("guess.out");
  int n;
  fin >> n;
  vector<unordered_set<string> > animals;
  for(int i = 0; i < n; i++){
    animals[i] = unordered_set<string>();
    string a;
    int k;
    fin >> a >> k;
    for(int j = 0; j < k; j++){
      string val;
      fin >> val;
      animals[i].insert(val);
    }
  }
  int maxCommon = 0;
  for(int x = 0; x < n; x++){
    for(int y = 0; y < x; y++){
      int common = compare(animals[x], animals[y]);
      maxCommon = max(maxCommon, common);
    }
  }
  fout << maxCommon << endl;
}
