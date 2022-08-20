import java.util.*;
import java.io.*;
public class photo{
  public static int n;
  public static boolean[] visited;
  public static String[] nums;

  public static void reset(){
    for(int i = 1; i <= n; i++){
      visited[i] = false;
    }
  }
  public static ArrayList<Integer> solve(ArrayList<Integer> current){
    if(current.size()==0){
      for(int i = 1; i <= n; i++){
        current.add(i);
        visited[i]=true;
        solve(current);
        reset();
      }
    }
    else if(current.size()==n){
      return current;
    }
    else if(current.size() < n){
      int a = Integer.parseInt(nums[current.size()-1])-current.get(current.size()-1);
      if(a > 0 && a <= n && !visited[a]){
        current.add(a);
        visited[a]=true;
        solve(current);
        reset();
      }
      else{
        current.clear();
      }
    }
    return current;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("photo.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
    n = Integer.parseInt(f.readLine());
    visited = new boolean[n+1];
    nums = f.readLine().split(" ");
    ArrayList<Integer> current = new ArrayList<Integer>(50);
    reset();
    ArrayList<Integer> ans = solve(current);
    for(int j = 0; j < n-1; j++){
      out.print(current.get(j) + " ");
    }
    out.print(current.get(n-1));
    out.close();
  }
}
