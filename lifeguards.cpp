#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b){
    if(a.first == b.first){
        return a.second < b.second;
    }
    return a.first < b.first;
}
int main(){
    ifstream fin("lifeguards.in");
    ofstream fout("lifeguards.out");
    int n;
    /*
    vector<pair<int, int>> intervals;
    for(int i = 0; i < n; i++){
        int a, b;
        fin >> a >> b;
        pair<int, int> s(a, b);
        intervals.push_back(s);
    }
    sort(intervals.begin(), intervals.end(), cmp);
    int prevEnd = 0;
    int total = 0;
    for(int j = 0; j < n; j++){
        int start = intervals[j].first;
        int end = intervals[j].second;
        if(start > prevEnd){
            total += (end - start);
        }
    }
    */
}