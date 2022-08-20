import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
  public int val;
  public int pos;
  public Pair(int a, int b){
    val = a;
    pos = b;
  }
  public int compareTo(Pair other){
    return other.val-val;
  }
  public String toString(){
    return "(" + val + ", " + pos + ")";
  }
}
public class reststops{
  public static void main(String[] args) throws IOException{
    BufferedReader h = new BufferedReader(new FileReader("reststops.in"));
    PrintWriter out = new PrintWriter(new FileWriter("reststops.out"));
    String[] parts = h.readLine().split(" ");
    int l = Integer.parseInt(parts[0]);
    int n = Integer.parseInt(parts[1]);
    int f = Integer.parseInt(parts[2]);
    int b = Integer.parseInt(parts[3]);
    Pair[] arr = new Pair[n];
    Stack<Pair> arr2 = new Stack<Pair>();
    for(int i = 0; i < n; i++){
      parts = h.readLine().split(" ");
      arr[i] = new Pair(Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
    }
    int pos = n-1;
    long total = 0;
    for(int j = n-1; j >= 0; j--){
      if(arr[j].val >= arr[pos].val){
        pos = j;
        arr2.push(arr[j]);
      }
    }
    pos = 0;
    while(!arr2.empty()){
      Pair x = arr2.pop();
      total += (long)(x.pos-pos)*(f-b)*x.val;
      pos = x.pos;
    }
    out.println(total);
    out.close();
  }
}
