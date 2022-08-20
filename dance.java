import java.io.*;
import java.util.*;
public class dance{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] pos = new int[n+1];
    ArrayList<HashSet<Integer>> visited = new ArrayList<HashSet<Integer>>(n+1);
    for(int g = 0; g < n+1; g++){
      visited.add(new HashSet<Integer>(n+1));
    }
    for(int r = 0; r < n+1; r++){
      pos[r] = r;
    }
    for(int r1 = 0; r1 < n+1; r1++){
      visited.get(r1).add(r1);
    }
    for(int i = 0; i < k; i++){
      st = new StringTokenizer(f.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      visited.get(pos[a]).add(b);
      visited.get(pos[b]).add(a);
      int temp = pos[a];
      pos[a] = pos[b];
      pos[b] = temp;
    }
    int[] arr = new int[n+1];
    for(int x = 0; x < n+1; x++){
      arr[x] = 0;
    }
    for(int j = 1; j < n+1; j++){
      if(arr[j] == 0){
        HashSet<Integer> h = visited.get(j);
        int temp = j;
        Stack<Integer> s = new Stack<Integer>();
        s.push(temp);
        while(pos[temp] != j){
          h.addAll(visited.get(pos[temp]));
          temp = pos[temp];
          s.push(temp);
        }
        while(!s.empty()){
          arr[s.pop()] = h.size();
        }
      }
    }
    for(int f1 = 1; f1 < n+1; f1++){
      System.out.println(arr[f1]);
    }
  }
}
