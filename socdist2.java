import java.util.*;
import java.io.*;
public class socdist2{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("socdist2.in"));
    PrintWriter out = new PrintWriter(new FileWriter("socdist2.out"));
    int n = Integer.parseInt(f.readLine());
    int[] arr = new int[n];
    int[] infectArr = new int[n];
    boolean[] infected = new boolean[1000001];
    for(int i = 0; i < n; i++){
      String[] parts = f.readLine().split(" ");
      int position = Integer.parseInt(parts[0]);
      int infect = Integer.parseInt(parts[1]);
      if(infect == 1){
        infected[position] = true;
      }
      else{
        infected[position] = false;
      }
      arr[i] = position;
    }
    Arrays.sort(arr);
    for(int j = 0; j < n; j++){
      if(infected[arr[j]] == true){
        infectArr[j] = 1;
      }
      else{
        infectArr[j] = 0;
      }
    }

    int min = 1000000;
    int ans = 0;
    for(int k = 1; k < n; k++){
      if(infectArr[k] != infectArr[k-1]){
        min = Math.min(arr[k]-arr[k-1], min);
        if(infectArr[k] == 1){
          ans++;
        }
      }
    }
    for(int l = 1; l < n; l++){
      if(infectArr[l] == infectArr[l-1] && infectArr[l] == 1 && arr[l] - arr[l-1] >= min){
        ans++;
      }
    }
    if(infectArr[0] == 1){
      ans++;
    }
    out.println(ans);
    out.close();
  }
}
