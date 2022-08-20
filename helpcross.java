import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
  public int a;
  public int b;
  public Pair(int a, int b){
    this.a = a;
    this.b = b;
  }
  public int compareTo(Pair other){
    return b-other.b;
  }
}
public class helpcross{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("helpcross.in"));
    PrintWriter out = new PrintWriter(new FileWriter("helpcross.out"));
    String[] nums = f.readLine().split(" ");
    int c = Integer.parseInt(nums[0]);
    int n = Integer.parseInt(nums[1]);
    int[] chickens = new int[c];
    Pair[] cows = new Pair[n];
    ArrayList<Pair> cowArr = new ArrayList<Pair>(n);
    for(int i = 0; i < c; i++){
      chickens[i] = Integer.parseInt(f.readLine());
    }
    for(int j = 0; j < n; j++){
      String[] parts = f.readLine().split(" ");
      cows[j] = new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }
    Arrays.sort(chickens);
    Arrays.sort(cows);
    for(int l = 0; l < n; l++){
      cowArr.add(cows[l]);
    }
    int ans = 0;
    for(int k = 0; k < c; k++){
      for(int m = 0; m < cowArr.size(); m++){
        if(chickens[k] >= cowArr.get(m).a && chickens[k] <= cowArr.get(m).b){
          ans++;
          cowArr.remove(m);
          break;
        }
      }
    }
    out.println(ans);
    out.close();
  }
}
