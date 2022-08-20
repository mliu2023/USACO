import java.util.*;
import java.io.*;
public class swap{
  public static int n;
  public static int k;
  public static int a1;
  public static int a2;
  public static int b1;
  public static int b2;
  public static int[] arr = new int[100];
  public static boolean[] used = new boolean[100];
  public static void swap(int a, int b){
    for(int i = a; i <= (a+b)/2; i++){
      int temp = arr[i];
      arr[i]=arr[b-i+a];
      arr[b-i+a]=temp;
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
      arr[i]=i;
    }
    for(int j = 0; j < k; j++){
      swap(a1, a2);
      swap(b1, b2);
    }
    for(int x = 1; x <= n; x++){
      out.println(arr[x]);
    }
    out.close();
  }
}
