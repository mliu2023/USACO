#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

int n;
bool visited[1000][1000];
vector<string> grid;

bool cmp(pair<int, int> a, pair<int, int> b){
    if(a.first == b.first){
        return a.second < b.second;
    }
    return a.first > b.first;
}

pair<int, int> dfs(int r, int c, int n, vector<string> grid, pair<int, int> p){
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    p.first += 1;
    for(int i = 0; i < 4; i++){
        int nextR = r + dx[i];
        int nextC = c + dy[i];
        if(nextR < 0 || nextR >= n){
            p.second += 1;
        }
        else if(nextC < 0 || nextC >= n){
            p.second += 1;
        }
        else if(grid[nextR][nextC] == '.'){
            p.second += 1;
        }
        else{
            dfs(nextR, nextC, n, grid, p);
        }
    }
    return p;
}
int main(){
    ifstream fin("icyperimeter.in");
    ofstream fout("icyperimeter.out");
    fin >> n;
    for(int i = 0; i < n; i++){
        char str[n];
        fin.getline(str, n, '\n');
        grid.push_back(str);
    }
    int maxArea = 0;
    int maxPerimeter = INT32_MAX;
    for(int r = 0; r < n; r++){
        for(int c = 0; c < n; c++){
            if(grid[r][c] == '.'){
                visited[r][c] = true;
            }
            if(!visited[r][c]){
                pair<int, int> p = dfs(r, c, n, grid, pair<int, int>(0,0));
                int area = p.first;
                int perimeter = p.second;
                if(area == maxArea){
                    if(perimeter < maxPerimeter){
                        maxPerimeter = perimeter;
                    }
                }
                else if(area > maxArea){
                    maxArea = area;
                    maxPerimeter = perimeter;
                }
            }
        }
    }
    fout << maxArea << " " << maxPerimeter << endl;
}