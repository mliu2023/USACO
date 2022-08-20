#include <iostream>
#include <fstream>
#include <string>
#include <vector>

#define MAXN 100001

using namespace std;

int m, n;
bool color[MAXN];
bool visited[MAXN];
vector<pair<int, int> > adj[MAXN];

int dfs(int node){
    visited[node] = true;
    bool failed = false;
    for(pair<int, int> next : adj[node]){
        int edgeType = next.second;
        if(visited[next.first]){
            if(edgeType){
                if (!color[next.first] == color[node]){
                    return 0;
                }
            }
            else{
                if(color[next.first] == color[node]){
                    return 0;
                }
            }
        }
        else{
            if(edgeType){
                color[next.first] = color[node];
            }
            else{
                color[next.first] = !color[node];
            }
            if(!dfs(next.first)){
                failed = true;
                break;
            }
        }
    }
    return !failed;
}
int main(){
    ifstream fin("revegetate.in");
    ofstream fout("revegetate.out");
    fin >> n >> m;
    for(int i = 0; i < m; i++){
        char s;
        int a, b;
        fin >> s >> a >> b;
        bool edgeType = (s == 'S'); // same is 1
        //fout << s << a << b << edgeType << endl;
        pair<int, int> p(b, edgeType);
        pair<int, int> q(a, edgeType);
        adj[a].push_back(p);
        adj[b].push_back(q);
    }
    int connectedComponents = 0;
    for(int j = 1; j <= n; j++){
        if(!visited[j]){
            color[j] = 0;
            int x = dfs(j);
            //fout << x << endl;
            if(x == 0){
                fout << "0" << endl;
                exit(0);
            }
            else{
                connectedComponents += 1;
            }
        }
    }
    string str(connectedComponents, '0');
    fout << "1" << str << endl;
}