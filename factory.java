import java.io.*;
import java.util.*;
public class factory{
  public static ArrayList<ArrayList<Integer>> adj;
  public static int n;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("factory.in"));
    PrintWriter out = new PrintWriter(new FileWriter("factory.out"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    n = Integer.parseInt(st.nextToken());
    adj = new ArrayList<ArrayList<Integer>>(n+1);
    for(int r = 0; r < n+1; r++){
      adj.add(new ArrayList<Integer>(n));
    }
    for(int i = 0; i < n-1; i++){
      st = new StringTokenizer(f.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj.get(a).add(b);
    }
    for(int j = 1; j < n+1; j++){
      if(check(j)){
        out.println(j);
        out.close();
        break;
      }
    }
    out.println(-1);
    out.close();
  }
  public static boolean check(int j){
    for(int k = 1; k < n+1; k++){
      if(!dfs(k,j,k)){
        return false;
      }
    }
    return true;
  }
  public static boolean dfs(int node, int goalNode, int firstNode){
    if(node == goalNode){
      return true;
    }
    boolean total = false;
    for(int next : adj.get(node)){
      total = total || dfs(next, goalNode, firstNode);
      if(total == true){
        return true;
      }
    }
    return false;
  }
}
