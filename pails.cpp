#include<iostream>
#include<fstream>
#include<string>
using namespace std;
int x, y, m;
int main(){
  ofstream fout ("pails.out");
  ifstream fin ("pails.in");
  fin >> x >> y >> m;
  int max = 0;
  for(int i = 0; i <= m/y; i++){
    max = std::max(max, m-((m-i*y)%x));
  }
  fout << max << endl;
}
