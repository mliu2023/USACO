import java.io.*;
import java.util.*;
public class closing{
  public static int n;
  public static int m;
  public static ArrayList<ArrayList<Integer>> adj;
  public static boolean[] visited;
  public static int[] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("closing.in"));
    PrintWriter out = new PrintWriter(new FileWriter("closing.out"));
    String[] nums = f.readLine().split(" ");
    n = Integer.parseInt(nums[0]);
    m = Integer.parseInt(nums[1]);
    adj = new ArrayList<ArrayList<Integer>>(n+1);
    visited = new boolean[n+1];
    arr = new int[n];
    for(int z = 0; z < n+1; z++){
      adj.add(new ArrayList<Integer>(n));
    }
    for(int i = 0; i < m; i++){
      String[] parts = f.readLine().split(" ");
      int a = Integer.parseInt(parts[0]);
      int b = Integer.parseInt(parts[1]);
      adj.get(a).add(b);
      adj.get(b).add(a);
    }
    for(int j = 0; j < n; j++){
      arr[j] = Integer.parseInt(f.readLine());
    }
    for(int k = 0; k < n; k++){
      if(n-k == dfs(arr[k])+1){
        out.println("YES");
      }
      else{
        out.println("NO");
      }
      for(int l : adj.get(arr[k])){
        adj.get(l).remove(Integer.valueOf(arr[k]));
      }
      adj.get(arr[k]).clear();
      visited = new boolean[n+1];
    }
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
