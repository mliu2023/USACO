#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(pair<long, long> a, pair<long, long> b){
    return a.first < b.first;
}

bool check(long x, int n, vector<pair<long, long> > intervals){
    long prevCow = INT8_MIN;
    int numPlaced = 0;
    for(int i = 0; i < intervals.size(); i++){
        if(prevCow + x > intervals[i].first && prevCow + x <= intervals[i].second){
            numPlaced += (intervals[i].second-prevCow-x)/x;
            if(numPlaced > 0){
                prevCow = intervals[i].first + x * numPlaced;
            }
        }
        else if(prevCow + x <= intervals[i].second){
            numPlaced += (intervals[i].second-intervals[i].first)/x;
            if(numPlaced > 0){
                prevCow = intervals[i].first + x * numPlaced;
            }
        }
    }
    return (numPlaced >= n);
}

vector<pair<long, long> > intervals;
int n, m;

int main(){
    ifstream fin("socdist.in");
    ofstream fout("socdist.out");
    fin >> n >> m;
    for(int i = 0; i < m; i++){
        long a, b;
        fin >> a >> b;
        intervals.push_back(pair<long, long>(a, b));
    }
    sort(intervals.begin(), intervals.end(), cmp);
    long lo = 1;
    long hi = 1000000000000000000;
    long ans = -1;
    while(lo <= hi){
        int mid = (lo+hi)/2;
        if(check(mid, n, intervals)){
            lo = mid + 1;
            ans = mid;
        }
        else{
            hi = mid - 1;
        }
    }
    fout << ans << endl;
}