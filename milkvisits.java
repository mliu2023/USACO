import java.io.*;
import java.util.*;
public class milkvisits{
  public static int[] parent;
  public static int n;
  public static int m;
  public static String str;
  public static void initialize(){
    for(int i = 0; i < n+1; i++){
      parent[i] = i;
    }
  }
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
    BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
    PrintWriter out = new PrintWriter(new FileWriter("milkvisits.out"));
    String[] nums = f.readLine().split(" ");
    str = f.readLine();
    n = Integer.parseInt(nums[0]);
    m = Integer.parseInt(nums[1]);
    parent = new int[n+1];
    initialize();
    for(int j = 0; j < n-1; j++){
      String[] parts = f.readLine().split(" ");
      int a = Integer.parseInt(parts[0]);
      int b = Integer.parseInt(parts[1]);
      if(str.substring(a-1, a).equals(str.substring(b-1,b))){
        union(a,b);
      }
    }
    for(int k = 0; k < m; k++){
      String[] ends = f.readLine().split(" ");
      int x = Integer.parseInt(ends[0]);
      int y = Integer.parseInt(ends[1]);
      if(find(x)==find(y)){
        if(str.substring(x-1,x).equals(ends[2])){
          out.print("1");
        }
        else{
          out.print("0");
        }
      }
      else{
        out.print("1");
      }
    }
    out.close();
  }
}
