#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

#define MAXN 1000

int n;
bool visited[MAXN];
vector<pair<int, long> > distArr[MAXN];

bool isConnected(){
    for(int i = 0; i < n; i++){
        if(visited[i] == false){
            return false;
        }
    }
    return true;
}

void dfs(int node, long dist){
    visited[node] = true;
    for(pair<int, long> next : distArr[node]){
        if(next.second <= dist && !visited[next.first]){
            dfs(next.first, dist);
        }
    }
}

int main(){
    ifstream fin("moocast.in");
    ofstream fout("moocast.out");
    fin >> n;
    vector<pair<int, int> > locations;
    for(int i = 0; i < n; i++){
        int a, b;
        fin >> a >> b;
        locations.push_back(pair<int, int>(a, b));
    }
    for(int j = 0; j < n; j++){
        for(int k = 0; k < n; k++){
            if(j != k){
                int x1, x2, y1, y2;
                x1 = locations[j].first;
                x2 = locations[k].first;
                y1 = locations[j].second;
                y2 = locations[k].second;
                long dist = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
                distArr[j].push_back(pair<int, long>(k, dist));
                distArr[k].push_back(pair<int, long>(j, dist));
            }
        }
    }
    long lo = 0, hi = 1250000000, ans = -1;
    while(lo <= hi){
        long mid = (lo+hi)/2;
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }
        dfs(0, mid);
        if(!isConnected()){
            lo = mid+1;
            ans = mid;
        }
        else{
            hi = mid-1;
        }
    }
    fout << ans+1 << endl;
}