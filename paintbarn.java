import java.io.*;
import java.util.*;
public class paintbarn{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
    PrintWriter out = new PrintWriter(new FileWriter("paintbarn.out"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
  }
}
