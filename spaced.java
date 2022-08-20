import java.io.*;
import java.util.*;
public class spaced{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[][] grid = new int[n][n];
    for(int r = 0; r < n; r++){
      st = new StringTokenizer(f.readLine());
      for(int c = 0; c < n; c++){
        grid[r][c] = Integer.parseInt(st.nextToken());
      }
    }
    int horizontaltotal = 0;
    for(int i = 0; i < n; i++){
      int oddtotal1 = 0;
      int eventotal1 = 0;
      for(int j = 0; j < n; j++){
        if(j%2==0){
          eventotal1 += grid[i][j];
        }
        else{
          oddtotal1 += grid[i][j];
        }
      }
      horizontaltotal += Math.max(eventotal1, oddtotal1);
    }
    int verticaltotal = 0;
    for(int l = 0; l < n; l++){
      int oddtotal2 = 0;
      int eventotal2 = 0;
      for(int k = 0; k < n; k++){
        if(k%2==0){
          eventotal2 += grid[k][l];
        }
        else{
          oddtotal2 += grid[k][l];
        }
      }
      verticaltotal += Math.max(eventotal2, oddtotal2);
    }
    System.out.println(Math.max(horizontaltotal, verticaltotal));
  }
}
