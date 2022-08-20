import java.util.*;
import java.io.*;
public class race{
  public static int k;
  public static int n;
  public static int rhstravel = 0;
  public static int lhstravel = 0;
  public static int time = 0;
  public static int solve(int x){
    for(int speed = 1;; speed++){
      lhstravel += speed;
      time++;
      if(lhstravel + rhstravel >= k){return time;}
      if(speed>=x){
        rhstravel += speed;
        time++;
        if(lhstravel + rhstravel >= k){return time;}
      }
    }
  }
  public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("race.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
      String[] nums = f.readLine().split(" ");
      k = Integer.parseInt(nums[0]);
      n = Integer.parseInt(nums[1]);
      int[] xVal = new int[n];
      for(int a = 0; a < n; a++){
        xVal[a] = Integer.parseInt(f.readLine());
      }
      for(int k = 0; k < n; k++){
        solve(xVal[k]);
        out.println(time);
        time = 0;
        lhstravel = 0;
        rhstravel = 0;
      }
      out.close();
    }
  }
