import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
  public int area;
  public int perimeter;
  public Pair(int a, int b){
    area = a;
    perimeter = b;
  }
  public int compareTo(Pair other){
    if(area == other.area){
      return other.perimeter - perimeter;
    }
    else{
      return other.area - area;
    }
  }
}
public class perimeter{
  public static int n;
  public static int[][] grid;
  public static boolean[][] visited;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
    PrintWriter out = new PrintWriter(new FileWriter("perimeter.out"));
    n = Integer.parseInt(f.readLine());
    grid = new int[n+2][n+2];
    visited = new boolean[n+2][n+2];
    for(int i = 0; i < n+2; i++){
      if(i == 0 || i == n+1){
        for(int j = 0; j < n+2; j++){
          grid[i][j] = 0;
        }
      }
      else{
        String[] parts = f.readLine().split("");
        for(int j = 0; j < n+2; j++){
          if(j == 0 || j == n+1){
            grid[i][j] = 0;
          }
          else{
            String str = parts[j-1];
            if(str.equals(".")){
              grid[i][j] = 0;
            }
            else{
              grid[i][j] = 1;
            }
          }
        }
      }
    }
    ArrayList<Pair> arr = new ArrayList<Pair>(n*n);
    for(int r = 1; r <= n; r++){
      for(int c = 1; c <= n; c++){
        if(!visited[r][c]){
          arr.add(solve(r,c));
        }
      }
    }
    Collections.sort(arr);
    out.println(arr);
    out.println(arr.get(0).area + " " + arr.get(0).perimeter);
  }
  public static Pair solve(int r, int c){
    int[] dirX = {1, -1, 0, 0};
    int[] dirY = {0, 0, 1, -1};
    Pair a = new Pair(1, 0);
    Pair b;
    visited[r][c] = true;
    for(int i = 0; i < 4; i++){
      if(grid[r+dirX[i]][c+dirY[i]] == 0){
        a.perimeter += 1;
      }
      else{
        if(!visited[r+dirX[i]][c+dirY[i]]){
          b = solve(r+dirX[i], c+dirY[i]);
          a.area += b.area;
          a.perimeter += b.perimeter;
        }
      }
    }
    return a;
  }
}
