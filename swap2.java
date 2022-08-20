import java.util.*;
import java.io.*;
public class swap2{
  public static int n;
  public static int k;
  public static int a1;
  public static int a2;
  public static int b1;
  public static int b2;
  public static ArrayList<Integer> arr = new ArrayList<Integer>(101);
  public static ArrayList<ArrayList<Integer>> cycles = new ArrayList<ArrayList<Integer>>(100);
  public static int[] newArr = new int[101];
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
    String[] nk = f.readLine().split(" ");
    n = Integer.parseInt(nk[0]);
    k = Integer.parseInt(nk[1]);
    String[] aNums = f.readLine().split(" ");
    a1 = Integer.parseInt(aNums[0]);
    a2 = Integer.parseInt(aNums[1]);
    String[] bNums = f.readLine().split(" ");
    b1 = Integer.parseInt(bNums[0]);
    b2 = Integer.parseInt(bNums[1]);
    for(int i = 0; i <= n; i++){
      arr.add(i);
    }


    swap(a1, a2);
    swap(b1, b2);


    for(int y = 1; y <= n; y++){
      ArrayList<Integer> cyc = new ArrayList<Integer>(10000);
      cyc.add(y);
      int index = arr.indexOf(y);
      while(index != y){
        cyc.add(index);
        index = arr.indexOf(index);
      }
      cycles.add(cyc);
    }
    for(int r = 1; r <= n; r++){
      ArrayList<Integer> cycArr = cycles.get(r-1);
      newArr[cycArr.get(k%cycArr.size())]= r;
    }
    for(int g = 1; g <= n; g++){
      out.println(newArr[g]);
    }
    out.close();
  }
}
