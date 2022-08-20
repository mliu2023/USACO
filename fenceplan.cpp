#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

#define MAXN 100001

int n, m;
vector<int> adj[100001];
bool visited[100001];
vector<pair<int, int> > arr;

int x1, x2, y1, y2;
int dfs(int node){
  //cout << node << endl;
  visited[node] = true;
  x1 = min(x1, arr[node].first);
  x2 = max(x2, arr[node].first);
  y1 = min(y1, arr[node].second);
  y2 = max(y2, arr[node].second);
  for(int next : adj[node]){
    if(!visited[next]){
      dfs(next);
    }
  }
  return 2*(x2-x1+y2-y1);
}

int main(){
  ifstream fin ("fenceplan.in");
  ofstream fout ("fenceplan.out");
  fin >> n >> m;
  pair<int, int> p1(-1,-1);
  arr.push_back(p1);
  for(int j = 0; j < n; j++){
    int a, b;
    fin >> a >> b;
    arr.push_back(pair<int, int>(a, b));
  }
  for(int i = 0; i < m; i++){
    int a, b;
    fin >> a >> b;
    adj[a].push_back(b);
    adj[b].push_back(a);
  }
  int minPerimeter = INT32_MAX;
  for(int k = 1; k <= n; k++){
    if(!visited[k]){
      x1 = arr[k].first;
      x2 = arr[k].first;
      y1 = arr[k].second;
      y2 = arr[k].second;
      int perimeter = dfs(k);
      //fout << perimeter << endl;
      minPerimeter = min(perimeter, minPerimeter);
    }
  }
  fout << minPerimeter << endl;
}
