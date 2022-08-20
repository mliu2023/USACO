import java.util.*;
import java.io.*;
public class lemonade{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("lemonade.in"));
    PrintWriter out = new PrintWriter(new FileWriter("lemonade.out"));
    int n = Integer.parseInt(f.readLine());
    String[] parts = f.readLine().split(" ");
    int[] cows = new int[n];
    for(int i = 0; i < n; i++){
      cows[i] = Integer.parseInt(parts[i]);
    }
    Arrays.sort(cows);
    for(int j = n-1; j >= 0; j--){
      if(cows[j] < n-1-j){
        out.println(n-1-j);
        out.close();
        break;
      }
    }
    if(cows[0] >= n-1){
      out.println(n);
      out.close();
    }
  }
}
