import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
  public int a;
  public int b;
  public Pair(int a, int b){
    this.a = a;
    this.b = b;
  }
  public int getFirst(){
    return a;
  }
  public int getSecond(){
    return b;
  }
  public int compareTo(Pair other){
    return a-other.a;
  }
}
public class sort{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("sort.in"));
    PrintWriter out = new PrintWriter(new FileWriter("sort.out"));
    int n = Integer.parseInt(f.readLine());
    Pair[] arr = new Pair[n];
    int ans = 0;
    for(int i = 0; i < n; i++){
      arr[i] = new Pair(Integer.parseInt(f.readLine()), i);
    }
    Arrays.sort(arr);
    for(int j = 0; j < n; j++){
      ans = Math.max(ans, Math.abs(arr[j].getSecond()-j));
    }
    out.println(ans+1);
    out.close();
  }
}
