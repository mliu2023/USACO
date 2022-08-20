import java.util.*;
import java.io.*;
class Pair implements Comparable<Pair>{
  public int x;
  public int y;
  public Pair(int x, int y){
    this.x = x;
    this.y = y;
  }
  public int compareTo(Pair other){
    return y-other.y;
  }
}
public class mountains{
  public static boolean check(Pair p1, Pair p2){
    return(p2.y >= (-p2.x+p1.x)+p1.y && p2.y >= (p2.x-p1.x)+p1.y);
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("mountains.in"));
    PrintWriter out = new PrintWriter(new FileWriter("mountains.out"));
    int n = Integer.parseInt(f.readLine());
    Pair[] arr = new Pair[n];
    int ans = n;
    for(int i = 0; i < n; i++){
      String[] parts = f.readLine().split(" ");
      arr[i] = new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }
    Arrays.sort(arr);
    for(int j = 0; j < n-1; j++){
      for(int k = j+1; k < n; k++){
        if(check(arr[j], arr[k])){
          ans--;
          break;
        }
      }
    }
    out.println(ans);
    out.close();
  }
}
