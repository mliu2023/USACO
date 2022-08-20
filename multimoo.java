import java.util.*;
import java.io.*;
public class multimoo{
  public static int n;
  public static int val2 = -1;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("multimoo.in"));
    PrintWriter out = new PrintWriter(new FileWriter("multimoo.out"));
    n = Integer.parseInt(f.readLine());
    int[][] arr = new int[n][n];
    boolean[][] visited = new boolean[n][n];
    boolean[][] visited2 = new boolean[n][n];
    int max1 = 0;
    int max2 = 0;
    for(int i = 0; i < n; i++){
      String[] parts = f.readLine().split(" ");
      for(int j = 0; j < n; j++){
        arr[i][j] = Integer.parseInt(parts[j]);
        visited[i][j] = false;
        visited2[i][j] = false;
      }
    }
    for(int r = 0; r < n; r++){
      for(int c = 0; c < n; c++){
        max1 = Math.max(max1, solve(r, c, arr, arr[r][c], visited));
        max2 = Math.max(max2, solve2(r, c, arr, arr[r][c], visited2));
        val2 = -1;
        visited = new boolean[n][n];
        visited2 = new boolean[n][n];
      }
    }
    out.println(max1);
    out.println(max2);
    out.close();
  }
  public static int solve(int r, int c, int[][] arr, int val, boolean[][] visited){
    if(r <= n-1 && r >= 0 && c <= n-1 && c >= 0){
      if(arr[r][c] == val && !visited[r][c]){
        visited[r][c] = true;
        return ((((1+solve(r+1, c, arr, val, visited))+solve(r-1, c, arr, val, visited))+solve(r, c+1, arr, val, visited))+solve(r, c-1, arr, val, visited));
      }
      return 0;
    }
    return 0;
  }
  public static int solve2(int r, int c, int[][] arr, int val1, boolean[][] visited2){
    if(r <= n-1 && r >= 0 && c <= n-1 && c >= 0 && !visited2[r][c]){
      if(val2 == -1 && arr[r][c] != val1){
        val2 = arr[r][c];
      }
      if((arr[r][c] == val1 || arr[r][c] == val2)){
        visited2[r][c] = true;
        return ((((1+solve2(r+1, c, arr, val1, visited2))+solve2(r-1, c, arr, val1, visited2))+solve2(r, c+1, arr, val1, visited2))+solve2(r, c-1, arr, val1, visited2));
      }
      return 0;
    }
    return 0;
  }
}
