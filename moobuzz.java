import java.io.*;
import java.util.*;
public class moobuzz{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("moobuzz.in"));
    PrintWriter out = new PrintWriter(new FileWriter("moobuzz.out"));
    int n = Integer.parseInt(f.readLine());
    int[] arr = {-1, 1, 2, 4, 7, 8, 11, 13};
    out.println((n/8)*15 + arr[n%8]);
    out.close();
  }
}
