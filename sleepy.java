import java.util.*;
import java.io.*;
public class sleepy{
  public static int n;
  public static ArrayList<Integer> arr = new ArrayList<Integer>(101);
  public static ArrayList<Integer> arr2 = new ArrayList<Integer>(101);
  public static boolean checkSequence(){
    for(int i = 0; i < arr2.size(); i++){
      if(arr2.get(i) != i+1){return false;}
    }
    return true;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
    n = Integer.parseInt(f.readLine());
    String[] nums = f.readLine().split(" ");
    for(int i = 0; i < nums.length; i++){
      arr.add(Integer.parseInt(nums[i]));
    }
    arr2 = arr;
    int ans = 0;
    while(ans <= n){
      for(int j = 0; j < ans; j++){
        arr2.add(arr.get(0)+ans-j-1, arr.get(0));
        arr2.remove(0);
      }
      System.out.println(arr2);
      if(checkSequence()){
        out.println(ans);
        break;
      }
      arr2 = arr;
      ans++;
    }
    out.close();
  }
}
