/*
TASK: milk3
ID: maximus9
LANG: JAVA
*/
import java.util.*;
import java.io.*;
public class milk3{
  public static int[] amounts = new int[3];
  public static int[] milk = new int[3];
  public static ArrayList<Integer> sols = new ArrayList<Integer>(21);
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
    PrintWriter out = new PrintWriter(new FileWriter("milk3.out"));
    String[] nums = f.readLine().split(" ");
    amounts[0]=Integer.parseInt(nums[0]);
    amounts[1]=Integer.parseInt(nums[1]);
    amounts[2]=Integer.parseInt(nums[2]);
    milk[2]=amounts[2];
    Collections.sort(sols);
    for(int i = 0; i < sols.size()-1; i++){
      out.print(sols.get(i));
      out.print(" ");
    }
    out.print(sols.get(sols.size()-1));
    out.println();
    out.close();
  }
  public static void solve(){
    
  }
}
