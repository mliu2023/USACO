#include <iostream>
#include <cmath>

using namespace std;

int main(){
    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        long a, b;
        cin >> a >> b;
        int counter = 0;
        while(a > b){
            if(a % 2 == 0){
                a = a/2;
                counter++;
            }
            else{
                a = a + 1;
                counter++;
            }
        }
        int doublecounter = 0;
        while(2*a <= b){
            a = a * 2;
            counter++;
            doublecounter++;
        }
        int diff = b-a;
        for(int j = doublecounter; j >= 0; j--){
            int p = (int)pow(2, j);
            counter += diff/p;
            diff = diff % p;
        }
        cout << counter << endl;
    }
}