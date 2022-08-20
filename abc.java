import java.util.*;
import java.io.*;
public class abc{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[7];
    String[] parts = f.readLine().split(" ");
    for(int i = 0; i < 7; i++){
      arr[i] = Integer.parseInt(parts[i]);
    }
    Arrays.sort(arr);
    if(arr[0]+arr[1] == arr[2]){
      System.out.println(arr[0] + " " + arr[1] + " " + arr[3]);
    }
    else{
      System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
    }
  }
}
