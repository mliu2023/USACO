import java.io.*;
import java.util.*;
class Cow{
  public int x;
  public int y;
  public int power;
  public Cow(int x, int y, int power){
    this.x = x;
    this.y = y;
    this.power = power;
  }
}
public class moocast{
  public static ArrayList<ArrayList<Integer>> adj;
  public static ArrayList<Cow> arr;
  public static int n;
  public static boolean[] visited;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
    PrintWriter out = new PrintWriter(new FileWriter("moocast.out"));
    n = Integer.parseInt(f.readLine());
    adj = new ArrayList<ArrayList<Integer>>(n);
    arr = new ArrayList<Cow>(n);
    visited = new boolean[n];
    for(int r = 0; r < n; r++){
      adj.add(new ArrayList<Integer>(n));
    }
    for(int i = 0; i < n; i++){
      String[] parts = f.readLine().split(" ");
      Cow c = new Cow(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
      arr.add(c);
    }
    for(int j = 0; j < n; j++){
      for(int k = 0; k < j; k++){
        Cow c1 = arr.get(j);
        Cow c2 = arr.get(k);
        long dist = (c1.x-c2.x)*(c1.x-c2.x)+(c1.y-c2.y)*(c1.y-c2.y);
        if(c1.power*c1.power >= dist){
          adj.get(j).add(k);
        }
        if(c2.power*c2.power >= dist){
          adj.get(k).add(j);
        }
      }
    }
    int max = 0;
    for(int node = 0; node < n; node++){
      max = Math.max(max, dfs(node));
      visited = new boolean[n];
    }
    out.println(max+1);
    out.close();
  }
  public static int dfs(int node){
    visited[node] = true;
    int total = 0;
    for(int next : adj.get(node)){
      if(!visited[next]){
        total += 1+dfs(next);
      }
    }
    return total;
  }
}
