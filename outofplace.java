import java.util.*;
import java.io.*;
public class outofplace{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
    PrintWriter out = new PrintWriter(new FileWriter("outofplace.out"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    int b = -1;
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(f.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
      if(i > 0 && arr[i] < arr[i-1]){
        b = i;
      }
    }
    if(b == -1){
      out.println(0);
      out.close();
    }
    else{
      int keep = b;
      int ans = 0;
      for(int j = b-1; j >= 1; j--){
        if(arr[b] < arr[j] && arr[j] != arr[j-1]){
          int temp = arr[b];
          arr[b] = arr[j];
          arr[j] = temp;
          b = j;
          ans++;
        }
      }
      b = keep;
      for(int k = b+1; k <= n-2; k++){
        if(arr[b] > arr[k] && arr[k] != arr[k+1]){
          int temp = arr[b];
          arr[b] = arr[k];
          arr[k] = temp;
          b = k;
          ans++;
        }
      }
      out.println(ans);
      out.close();
    }
  }
}
