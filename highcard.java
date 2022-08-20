import java.io.*;
import java.util.*;
public class highcard{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("highcard.in"));
    PrintWriter out = new PrintWriter(new FileWriter("highcard.out"));
    int n = Integer.parseInt(f.readLine());
    int[] elsie = new int[n];
    int[] bessie = new int[n];
    HashSet<Integer> eSet = new HashSet<Integer>(n);
    for(int i = 0; i < n; i++){
      elsie[i] = Integer.parseInt(f.readLine());
      eSet.add(elsie[i]);
    }
    int counter = 0;
    for(int l = 1; l <= 2*n; l++){
      if(!eSet.contains(l)){
        bessie[counter] = l;
        counter++;
      }
    }
    Arrays.sort(elsie);
    Arrays.sort(bessie);
    int curr = 0;
    int ans = 0;
    for(int j = 0; j < n; j++){
      for(int k = curr; k < n; k++){
        if(bessie[k] > elsie[j]){
          curr = k+1;
          ans++;
          break;
        }
      }
      if(curr == n){
        break;
      }
    }
    out.println(ans);
    out.close();
  }
}
