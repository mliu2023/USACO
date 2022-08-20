import java.util.*;
import java.io.*;
class Edge{
  int to;
  int weight;
  public Edge(int to, int weight){
    this.to = to;
    this.weight = weight;
  }
}
public class mootube{
  public static int n;
  public static int q;
  public static ArrayList<ArrayList<Edge>> adj;
  public static boolean[] visited;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
    PrintWriter out = new PrintWriter(new FileWriter("mootube.out"));
    String[] nums = f.readLine().split(" ");
    n = Integer.parseInt(nums[0]);
    q = Integer.parseInt(nums[1]);
    adj = new ArrayList<ArrayList<Edge>>(n+1);
    visited = new boolean[n+1];
    for(int i = 0; i < n+1; i++){
      adj.add(new ArrayList<Edge>(n));
    }
    for(int l = 0; l < n-1; l++){
      String[] parts = f.readLine().split(" ");
      int a = Integer.parseInt(parts[0]);
      int b = Integer.parseInt(parts[1]);
      int weight = Integer.parseInt(parts[2]);
      adj.get(a).add(new Edge(b, weight));
      adj.get(b).add(new Edge(a, weight));
    }
    for(int j = 0; j < q; j++){
      String[] strs = f.readLine().split(" ");
      Stack<Edge> s = new Stack<Edge>();
      out.println(dfs(Integer.parseInt(strs[1]), Integer.parseInt(strs[0])));
      visited = new boolean[n+1];
    }
    out.close();
  }
  public static int dfs(int node, int k){
    visited[node] = true;
    int total = 0;
    for(Edge next : adj.get(node)){
      if(!visited[next.to] && next.weight >= k){
        total += 1+dfs(next.to, k);
      }
    }
    return total;
  }
}
