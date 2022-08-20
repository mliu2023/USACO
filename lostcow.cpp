#include <iostream>
#include <fstream>
#include <cmath>

using namespace std;

int main(){
  ifstream fin ("lostcow.in");
  ofstream fout ("lostcow.out");
  int x, y;
  fin >> x >> y;
  int diff = y-x;
  if(diff > 0){
    int counter = 1;
    while(counter < diff){
      counter *= 4;
    }
    int total = 1+3*(counter-1) + diff - counter;
    fout << total << endl;
  }
  else{
    int counter = 2;
    while(counter + diff < 0){
      counter *= 4;
    }
    int total = 1+3*(counter-1) - diff - counter;
    fout << total << endl;
  }
}
