#include <iostream>
#include <vector>

using namespace std;

int main(){
    int n;
    int arr[n][n];
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            int x;
            cin >> x;
            arr[i][j] = x;
        }
    }
    int arr100[n+1][n+1] = {0};
    int arr200[n + 1][n + 1] = {0};
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if (arr[i][j] == 100)
            {
                arr100[i][j] = arr100[i-1][j]+arr100[i][j-1]-arr100[i-1][j-1]+1;
            }
            else
            {
                arr100[i][j] = arr100[i-1][j]+arr100[i][j-1]-arr100[i-1][j-1]+1;
            }

            if (arr[i][j] > 100)
            {
                arr200[i][j] = arr200[i - 1][j] + arr200[i][j - 1] - arr200[i - 1][j - 1] + 1;
            }
            else
            {
                arr200[i][j] = arr200[i - 1][j] + arr200[i][j - 1] - arr200[i - 1][j - 1] + 1;
            }
        }
    }
}