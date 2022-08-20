import java.io.*;
import java.util.*;
public class paint{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    String str = "@" + f.readLine() + "@";
    boolean[] possible = new boolean[26];
    int[] left = new int[n+2];
    int[] right = new int[n+2];
    for(int i = 1; i < n+1; i++){
      int index = (int)str.charAt(i)-65;
      for(int j = index+1; j < 26; j++){
        possible[j] = false;
      }
      if(str.charAt(i) > str.charAt(i-1) || !possible[index]){
        left[i] = left[i-1]+1;
      }
      else{
        left[i] = left[i-1];
      }
      possible[index] = true;
    }
    possible = new boolean[26];
    for(int j = n; j > 0; j--){
      int index = (int)str.charAt(j)-65;
      for(int k = index+1; k < 26; k++){
        possible[k] = false;
      }
      if(str.charAt(j) > str.charAt(j+1) || !possible[index]){
        right[j] = right[j+1]+1;
      }
      else{
        right[j] = right[j+1];
      }
      possible[index] = true;
    }
    for(int x = 0; x < q; x++){
      st = new StringTokenizer(f.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      System.out.println(left[a-1] + right[b+1]);
    }
  }
}
