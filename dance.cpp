#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int main(){
    int n, k;
    cin >> n >> k;

    int arr[n+1];
    for(int i = 0; i <= n; i++){
        arr[i] = i;
    }

    vector<unordered_set<int> > setArr;
    for(int i = 0; i <= n; i++){
        unordered_set<int> x ({i});
        setArr.push_back(x);
    }
    for(int i = 0; i < k; i++){
        int a, b;
        cin >> a >> b;

        setArr[arr[a]].insert(arr[b]);
        setArr[arr[b]].insert(arr[a]);

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    vector<vector<int> > cycleArr;
    bool visited[n+1];
    for(int i = 0; i <= n; i++){
        visited[i] = false;
    }
    for (int c = 1; c <= n; c++)
    {
        if (!visited[c])
        {
            vector<int> cycle;
            int curr = c;
            do
            {
                visited[curr] = true;
                cycle.push_back(curr);
                curr = arr[curr];
            } while (curr != c);
            cycleArr.push_back(cycle);
        }
    }


    int sizeArr[n+1];
    for(vector<int> cyc : cycleArr){
        unordered_set<int> set;
        for(int i = 0; i < cyc.size(); i++){
            set.insert(setArr[cyc[i]].begin(), setArr[cyc[i]].end());
        }
        int size = set.size();
        for(int i = 0; i < cyc.size(); i++){
            sizeArr[cyc[i]] = size;
        }
    }
    for(int i = 1; i <= n; i++){
        cout << sizeArr[i] << endl;
    }

}