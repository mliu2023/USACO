import java.io.*;
import java.util.*;
public class homework{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("homework.in"));
    PrintWriter out = new PrintWriter(new FileWriter("homework.out"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(f.readLine());
    int[][] arr = new int[n+1][2];
    arr[0][1] = Integer.MAX_VALUE;
    for(int k = 1; k < n+1; k++){
      int a = Integer.parseInt(st.nextToken());
      arr[k][0] = arr[k-1][0] + a;
    }
    arr[n][1] = arr[n][0] - arr[n-1][0];
    for(int i = n-1; i > 0; i--){
      arr[i][1] = Math.min(arr[i+1][1], arr[i][0]-arr[i-1][0]);
    }
    int maxTotal = 0;
    int maxNum = 1;
    ArrayList<Integer> maxArr = new ArrayList<Integer>(n);
    int total = arr[n][0];
    for(int j = 1; j < n-1; j++){
      int total1 = total - arr[j][0] - arr[j+1][1];
      if(total1*maxNum == maxTotal*(n-j)){
        maxArr.add(j);
      }
      else if(total1*maxNum > maxTotal*(n-j)){
        maxArr.clear();
        maxArr.add(j);
        maxTotal = total1;
        maxNum = n-j;
      }
    }
    Collections.sort(maxArr);
    for(int l = 0; l < maxArr.size(); l++){
      out.println(maxArr.get(l));
    }
    out.close();
  }
}
