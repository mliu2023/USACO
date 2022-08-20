import java.util.*;
import java.io.*;
public class convention{
  public static int n;
  public static int m;
  public static int c;
  public static int[] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("convention.in"));
    PrintWriter out = new PrintWriter(new FileWriter("convention.out"));
    String[] nums = f.readLine().split(" ");
    n = Integer.parseInt(nums[0]);
    m = Integer.parseInt(nums[1]);
    c = Integer.parseInt(nums[2]);
    arr = new int[n];
    String[] parts = f.readLine().split(" ");
    for(int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(parts[i]);
    }
    Arrays.sort(arr);
    out.println(search());
    out.close();
  }
  public static int search(){
    int pos = Integer.MAX_VALUE; int max = Integer.MAX_VALUE;
    for(int a = max; a >= 1; a/=2){
      while(check(pos-a)){
        pos -= a;
      }
    }
    return pos;
  }
  public static boolean check(int x){
    if(x < 0){
      return false;
    }
    int firstIndex = 0;
    int counter = 1;
    for(int i = 0; i < n; i++){
      if(arr[i]-arr[firstIndex] > x || i-firstIndex >= c){
        firstIndex = i;
        counter++;
      }
      if(counter > m){
        return false;
      }
    }
    return true;
  }
}
