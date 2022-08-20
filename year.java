import java.io.*;
import java.util.*;
public class year{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    HashSet<Integer> s = new HashSet<Integer>();
    ArrayList<Integer> arr = new ArrayList<Integer>(n);
    for(int i = 0; i < n; i++){
      int val = Integer.parseInt(f.readLine());
      int index = val/12+1;
      if(!s.contains(index)){
        s.add(index);
        arr.add(index);
      }
    }
    s.add(0);
    arr.add(0);
    Collections.sort(arr);
    //System.out.println(arr);
    int[] diffArr = new int[arr.size()-1];
    for(int j = 1; j < arr.size(); j++){
      diffArr[j-1] = arr.get(j)-arr.get(j-1)-1;
    }
    Arrays.sort(diffArr);
    //System.out.println(Arrays.toString(diffArr));
    int total = 0;
    for(int l = 0; l < arr.size()-k; l++){
      total += diffArr[l];
    }
    System.out.println(12*(total+arr.size()-1));
  }
}
