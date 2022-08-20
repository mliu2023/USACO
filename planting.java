import java.io.*;
import java.util.*;
public class planting{
  public static int n;
  public static int[] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("planting.in"));
    PrintWriter out = new PrintWriter(new FileWriter("planting.out"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    n = Integer.parseInt(st.nextToken());
    arr = new int[n+1];
    for(int i = 0; i < n-1; i++){
      st = new StringTokenizer(f.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a] += 1;
      arr[b] += 1;
    }
    int max = 0;
    for(int j = 1; j < n+1; j++){
      max = Math.max(max, arr[j]);
    }
    out.println(max+1);
    out.close();
  }
}
