import java.io.*;
import java.util.*;
class Triple implements Comparable<Triple>{
  public int a;
  public int b;
  public int c;
  public static boolean bool = true;
  public Triple(int a, int b, int c){
    this.a = a;
    this.b = b;
    this.c = c;
  }
  public int compareTo(Triple other){
    if(a == other.a || !bool){
      return c-other.c;
    }
    else{
      return a-other.a;
    }
  }
  public String toString(){
    return "(" + a + ", " + b + ", " + c + ")";
  }
}
public class convention2{
  public static int n;
  public static Triple[] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("convention2.in"));
    PrintWriter out = new PrintWriter(new FileWriter("convention2.out"));
    n = Integer.parseInt(f.readLine());
    arr = new Triple[n];
    for(int i = 0; i < n; i++){
      String[] parts = f.readLine().split(" ");
      arr[i] = new Triple(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), i);
    }
    Arrays.sort(arr);
    Triple.bool = false;
    int time = 0;
    int max = 0;
    for(int j = 0; j < n; j++){
      int k = j;
      while(k < n && arr[k].a <= time){
        k++;
      }
      if(k > j){
        Arrays.sort(arr,j,k);
      }
      if(time > arr[j].a){
        max = Math.max(max, time-arr[j].a);
        time += arr[j].b;
      }
      else{
        time = arr[j].a+arr[j].b;
      }
    }
    out.println(max);
    out.close();
  }
}
