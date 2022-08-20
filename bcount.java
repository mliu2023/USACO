import java.util.*;
import java.io.*;
public class bcount{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("bcount.in"));
    PrintWriter out = new PrintWriter(new FileWriter("bcount.out"));
    String[] nums = f.readLine().split(" ");
    int n = Integer.parseInt(nums[0]);
    int q = Integer.parseInt(nums[1]);
    int[][] arr = new int[n+1][4];
    for(int i = 1; i < n+1; i++){
      int type = Integer.parseInt(f.readLine());
      for(int l = 1; l < 4; l++){
        arr[i][l] = arr[i-1][l];
      }
      arr[i][type] = arr[i-1][type]+1;
    }
    for(int j = 0; j < q; j++){
      String[] parts = f.readLine().split(" ");
      int a = Integer.parseInt(parts[0]);
      int b = Integer.parseInt(parts[1]);
      for(int k = 1; k < 4; k++){
        out.print(arr[b][k]-arr[a-1][k]);
        if(k!=3){
          out.print(" ");
        }
      }
      out.println();
    }
    out.close();
  }
}
