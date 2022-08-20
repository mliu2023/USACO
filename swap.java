import java.io.*;
import java.util.*;
public class swap{
  public static int n;
  public static int m;
  public static int k;
  public static ArrayList<Integer> arr = new ArrayList<Integer>(10000);
  public static ArrayList<ArrayList<Integer>> cycles = new ArrayList<ArrayList<Integer>>(10000);
  public static int[] newArr;
  public static boolean[] used;
  public static void swap(int a, int b){
    for(int i = a; i <= (a+b)/2; i++){
      int temp = arr.get(i);
      arr.set(i, arr.get(b-i+a));
      arr.set(b-i+a, temp);
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("swap.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
    String[] nmk = f.readLine().split(" ");
    n = Integer.parseInt(nmk[0]);
    m = Integer.parseInt(nmk[1]);
    k = Integer.parseInt(nmk[2]);
    newArr = new int[n+1];
    used = new boolean[n+1];
    for(int z = 0; z <= n; z++){
      arr.add(z);
    }
    for(int i = 0; i < m; i++){
      String[] nums = f.readLine().split(" ");
      int a1 = Integer.parseInt(nums[0]);
      int a2 = Integer.parseInt(nums[1]);
      swap(a1, a2);
    }

    for(int y = 1; y <= n; y++){
      if(!used[y]){
        ArrayList<Integer> cyc = new ArrayList<Integer>(10000);
        cyc.add(y);
        used[y] = true;
        int index = arr.indexOf(y);
        while(index != y){
          cyc.add(index);
          used[index] = true;
          index = arr.indexOf(index);
        }
        cycles.add(cyc);
        for(int c = 0; c < cyc.size(); c++){
          newArr[cyc.get((k%cyc.size()+c)%cyc.size())] = cyc.get(c);
        }
      }
    }

    for(int g = 1; g <= n; g++){
      out.println(newArr[g]);
    }
    out.close();
  }
}
