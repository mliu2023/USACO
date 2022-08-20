import java.util.*;
import java.io.*;
public class div7{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("div7.in"));
    PrintWriter out = new PrintWriter(new FileWriter("div7.out"));
    int n = Integer.parseInt(f.readLine());
    int[] arr1 = new int[n+2];
    for(int i = 1; i < n+1; i++){
      arr1[i] = (Integer.parseInt(f.readLine())+arr1[i-1])%7;
    }
    int max = 0;
    for(int j = 1; j < 8; j++){
      int index1 = 1;
      while(index1 < n+1 && arr1[index1] != j){
        index1++;
      }
      int index2 = n;
      while(index2 > 0 && arr1[index2] != j){
        index2--;
      }
      if(index2>index1)
        max = Math.max(max, index2-index1);
    }
    out.println(max);
    out.close();
  }
}
