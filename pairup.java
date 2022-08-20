import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
  public int a;
  public int b;
  public Pair(int a, int b){
    this.a = a;
    this.b = b;
  }
  public int compareTo(Pair other){
    return b-other.b;
  }
  public String toString(){
    return "(" + a + ", " + b + ")";
  }
}
public class pairup{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("pairup.in"));
    PrintWriter out = new PrintWriter(new FileWriter("pairup.out"));
    int n = Integer.parseInt(f.readLine());
    Pair[] arr = new Pair[n];
    Queue<Pair> q = new LinkedList<Pair>();
    Stack<Pair> s = new Stack<Pair>();
    for(int i = 0; i < n; i++){
      String[] parts = f.readLine().split(" ");
      arr[i] = new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }
    Arrays.sort(arr);
    long total = 0;
    for(int z = 0; z < n; z++){
      total += arr[z].a;
    }
    for(int j = 0; j < n; j++){
      q.add(arr[j]);
      s.push(arr[j]);
    }
    long max = 0;
    int counter = 0;
    while(!s.empty() && !(q.peek()==null) && counter<total/2){
      counter++;
      Pair q1 = q.peek();
      Pair s1 = s.peek();
      max = Math.max(max, q1.b+s1.b);
      int x = q1.a;
      int y = s1.a;
      if(x>y){
        q1.a = x-y;
        s.pop();
      }
      else if(x<y){
        s1.a = y-x;
        q.poll();
      }
      else if(x == y){
        s.pop();
        q.poll();
      }
    }
    out.println(max);
    out.close();
  }
}
