import java.util.*;
import java.io.*;
public class closing2{
  public static int n;
  public static int m;
  public static int[] parent;
  public static ArrayList<ArrayList<Integer>> adj;
  public static Stack<Integer> s = new Stack<Integer>();
  public static Stack<String> s1 = new Stack<String>();
  public static HashSet<Integer> h = new HashSet<Integer>(n);
  public static HashSet<Integer> h1 = new HashSet<Integer>(n);
  public static int find(int node){
    if(node == parent[node]){
      return node;
    }
    else{
      return parent[node] = find(parent[node]);
    }
  }
  public static void union(int a, int b){
    int c = find(a);
    int d = find(b);
    if(c != d){
      parent[d] = c;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("closing.in"));
    PrintWriter out = new PrintWriter(new FileWriter("closing.out"));
    String[] nums = f.readLine().split(" ");
    n = Integer.parseInt(nums[0]);
    m = Integer.parseInt(nums[1]);
    parent = new int[n+1];
    adj = new ArrayList<ArrayList<Integer>>(n+1);
    for(int r = 0; r < n+1; r++){
      adj.add(new ArrayList<Integer>());
    }
    for(int i = 0; i < m; i++){
      String[] parts = f.readLine().split(" ");
      int x = Integer.parseInt(parts[0]);
      int y = Integer.parseInt(parts[1]);
      adj.get(x).add(y);
      adj.get(y).add(x);
    }
    for(int j = 0; j < n; j++){
      s.push(Integer.parseInt(f.readLine()));
    }
    boolean b = true;
    int n0 = s.peek();
    for(int k = 0; k < n; k++){
      int node = s.pop();
      h.add(node);
      parent[node] = node;
      for(int next : adj.get(node)){
        if(h.contains(next)){
          union(node, next);
        }
      }
      if(find(node)==find(n0)){
        s1.push("YES");
      }
      else{
        s1.push("NO");
      }
      /*
      for(int o = 1; o < n+1; o++){
        out.print(find(o));
      }
      out.println(h);
      out.println(h1);
      for(int l = 1; l < n+1; l++){
        int x = find(l);
        if(x!=0 && !h1.contains(x)){
          if(!h1.isEmpty()){
            s1.push("NO");
            b = false;
            break;
          }
          else{
            h1.add(x);
          }
        }
      }
      if(b){
        s1.push("YES");
      }
      b = true;
      h1.clear();
      */
    }
    while(!s1.empty()){
      out.println(s1.pop());
    }
    out.close();
  }
}
