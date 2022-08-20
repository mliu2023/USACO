#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

struct edge{
  int a;
  int b;
  int w;
  edge(int a, int b, int w){
    this->a = a;
    this->b = b;
    this->w = w;
  }
};

bool cmp(edge a, edge b){
  return a.w > b.w;
}

// union-find

int find(int a, int parent[]){
  if(a == parent[a]){
    return a;
  }
  else{
    return parent[a] = find(parent[a], parent);
  }
}

void initialize(int parent[], int n){
  for (int i = 1; i <= n; i++)
  {
    parent[i] = i;
  }
}
void unionfind(int a, int b, int parent[]){
  int c = parent[a];
  int d = parent[b];
  if(c != d){
    parent[d] = c;
  }
}

bool check(int x, vector<edge> edgeArr, int pos[], int n){
  int parent[n+1];
  for(int i = 1; i < n+1; i++){
    parent[i] = i;
  }
  for(int i = 0; i < x; i++){
    edge e = edgeArr[i];
    unionfind(e.a, e.b, parent);
  }
  for(int j = 1; j <= n; j++){
    if(find(pos[j], parent) != find(j, parent)){
      return false;
    }
  }
  return true;
}

int main(){
  int n, m;
  int parent[100001];
  int pos[100001];
  vector<edge> edgeArr;

  ifstream fin ("3.in");
  ofstream fout ("wormsort.out");
  fin >> n >> m;
  for(int i = 1; i <= n; i++){
    int node;
    parent[i] = i;
    fin >> node;
    pos[node] = i;
  }
  for(int i = 0; i < m; i++){
    int a, b, w;
    fin >> a >> b >> w;
    edgeArr.push_back(edge(a, b, w));
  }
  sort(edgeArr.begin(), edgeArr.end(), cmp);
  int lo = 0;
  int hi = m-1;
  int ans = -1;
  while(lo <= hi){
    int mid = (lo+hi)/2;
    if(!check(mid, edgeArr, pos, n)){
      lo = mid + 1;
      ans = mid;
    }
    else{
      hi = mid - 1;
    }
  }
  if(ans == -1){
    fout << "-1" << endl;
  }
  else{
    fout << edgeArr[ans].w << endl;
  }
  fout.close();
}
