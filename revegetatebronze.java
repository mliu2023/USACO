import java.util.*;
import java.io.*;
class Node{
  public int val;
  public int type;
  public Node(int a, int b){
    val = a;
    type = b;
  }
}
public class revegetatebronze{
  public static int n;
  public static int m;
  public static boolean[] visited;
  public static ArrayList<ArrayList<Node>> adj;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
    PrintWriter out = new PrintWriter(new FileWriter("revegetate.out"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    adj = new ArrayList<ArrayList<Node>>(n+1);
    visited = new boolean[n+1];
    for(int r = 0; r < n+1; r++){
      adj.add(new ArrayList<Node>(n));
    }
    for(int i = 0; i < m; i++){
      st = new StringTokenizer(f.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj.get(a).add(new Node(b, 0));
      adj.get(b).add(new Node(a, 0));
    }
    ArrayList<Node> x = adj.get(1);
    dfs(x.get(0));
    for(int k = 1; k <= n; k++){
      out.print(adj.get(k).type);
    }
    out.println();
    out.close();
  }
  public static boolean check(int i, Node node){
    for(Node next : adj.get(node.val)){
      if(next.val == i){
        return false;
      }
    }
    return true;
  }
  public static void dfs(Node node){
    visited[node.val] = true;
    for(int i = 1; i <= 4; i++){
      if(check(i, node)){
        node.type = i;
        break;
      }
    }
    for(Node next : adj.get(node.val)){
      if(!visited[next.val]){
        dfs(next);
      }
    }
  }
}
