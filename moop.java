import java.io.*;
import java.util.*;
class Pair implements Comparable<Pair>{
  public int x;
  public int y;
  public Pair(int x, int y){
    this.x = x;
    this.y = y;
  }
  public int compareTo(Pair other){
    if(x == other.x){
      return y-other.y;
    }
    else{
      return x-other.x;
    }
  }
}
public class moop{
  public static int[] parent;
  public static int n;
  public static Pair[] arr;
  /*
  public static int find(int x){
    if(x == parent[x]){
      return x;
    }
    else{
      return parent[x] = find(parent[x]);
    }
  }
  public static void union(int a, int b){
    int c = find(a);
    int d = find(b);
    if (c != d){
      parent[d] = c;
    }
  }
  */
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("moop.in"));
    PrintWriter out = new PrintWriter(new FileWriter("moop.out"));
    n = Integer.parseInt(f.readLine());
    parent = new int[n];
    arr = new Pair[n];
    for(int i = 0; i < n; i++){
      parent[i] = i;
    }
    for(int j = 0; j < n; j++){
      String[] parts = f.readLine().split(" ");
      arr[j] = new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }
    Arrays.sort(arr);
    /*
    for(int k = 0; k < n; k++){
      for(int l = k+1; l < n; l++){
        if((arr[k].x <= arr[l].x && arr[k].y <= arr[l].y) || (arr[k].x >= arr[l].x && arr[k].y >= arr[l].y)){
          union(k, l);
        }
      }
    }
    int ans = 0;
    HashSet<Integer> s = new HashSet<Integer>(n);
    for(int m = 0; m < n; m++){
      if(!s.contains(find(m))){
        s.add(find(m));
        ans++;
      }
    }
    */
    int[] minArr = new int[n];
    int[] maxArr = new int[n];
    minArr[0] = arr[0].y;
    maxArr[n-1] = arr[n-1].y;
    for(int p = 1; p < n; p++){
      minArr[p] = Math.min(minArr[p-1], arr[p].y);
    }
    for(int q = n-2; q >= 0; q--){
      maxArr[q] = Math.max(maxArr[q+1], arr[q].y);
    }
    int counter = 0;
    for(int r = 0; r < n-1; r++){
      if(minArr[r] > maxArr[r+1]){
        counter++;
      }
    }
    out.println(counter+1);
    out.close();
  }
}
