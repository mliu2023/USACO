import java.io.*;
import java.util.*;
public class cowntagion{
  public static int n;
  public static int[] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
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
    int total = 0;
    for(int j = 1; j < n+1; j++){
      total += calc(j);
    }
    System.out.println(total);
  }
  public static int calc(int node){
    int total = 0;
    int size = arr[node];
    if(node != 1){
      size--;
    }
    for(int i = 1; i < size+1; i*=2){
      total += 1;
    }
    return total + size;
  }
}
