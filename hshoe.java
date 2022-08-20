import java.util.*;
import java.io.*;
public class hshoe{
  public static int n;
  public static String[][] grid;
  public static int xPos = 0;
  public static int yPos = 0;
  public static boolean rights = false;
  public static boolean[][] visited;
  public static int left = 0;
  public static int right = 0;
  public static int largest = 0;
  public static int[] dx = {1,-1,0,0};
  public static int[] dy = {0,0,1,-1};

  public static void solve(){
    if(left == right && left != 0)
    {
      largest = Math.max(2*left, largest);
    }
    else if(rights && 2*left < largest)
    {
      largest = largest;
    }
    else{
      for(int i = 0; i < 4; i++)
      {
        if(xPos+dx[i]>=0 && xPos+dx[i]<n && yPos+dy[i]>=0 && yPos+dy[i]<n && !visited[xPos+dx[i]][yPos+dy[i]])
        {
          xPos += dx[i];
          yPos += dy[i];
          if(grid[xPos][yPos].equals("(") && !rights){
            left+=1;
            solve();
            left--;
          }
          else if(grid[xPos][yPos].equals(")") && rights){
            right+=1;
            rights = true;
            solve();
            right--;
          }
          xPos -= dx[i];
          yPos -= dy[i];
        }
      }
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("hshoe.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hshoe.out")));
    n = Integer.parseInt(f.readLine());
    grid = new String[n][];
    visited = new boolean[n][n];
    for(int i = 0; i < n; i++){
      String[] arr = f.readLine().split(" ");
      grid[i] = arr;
    }
    solve();
    out.println(largest);
    out.close();
  }
}
