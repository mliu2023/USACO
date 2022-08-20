#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

int main(){
    ifstream fin("swap.in");
    ofstream fout("swap.out");
    int n, m, k;
    fin >> n >> m >> k;

    int arr[n+1];

    for(int i = 0; i <= n; i++){
        arr[i] = i;
    }

    for(int j = 0; j < m; j++){
        int l, r;
        fin >> l >> r;
        for(int i = l; i <= (l+r)/2; i++){
            int temp = arr[i];
            arr[i] = arr[r+l-i];
            arr[r+l-i] = temp;
        }
    }

    vector<vector<int> > cycleArr;
    bool visited[n+1];
    for(int i = 0; i <= n; i++){
        visited[i] = false;
    }

    for(int c = 1; c <= n; c++){
        if(!visited[c]){
            vector<int> cycle;
            int curr = c;
            do{
                visited[curr] = true;
                cycle.push_back(curr);
                curr = arr[curr];
            }
            while (curr != c);
            cycleArr.push_back(cycle);
        }
    }
    int newpos[n+1];
    for(vector<int> cyc : cycleArr){
        for(int i = 0; i < cyc.size(); i++){
            newpos[cyc[i]] = cyc[(i+k)%cyc.size()];
        }
    }
    for(int i = 1; i <= n; i++){
        fout << newpos[i] << endl;
    }
}