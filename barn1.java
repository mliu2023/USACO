/*
ID: maximus9
LANG: JAVA
TASK: barn1
*/

import java.util.*;
import java.io.*;

public class barn1{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
    String[] arr = f.readLine().split(" ");
    int m = Integer.parseInt(arr[0]);
    int s = Integer.parseInt(arr[1]);
    int c = Integer.parseInt(arr[2]);
    int[] arr2 = new int[c];
    String line;
    int i = 0;
    while((line = f.readLine()) != null){
      arr2[i] = Integer.parseInt(line);
      i++;
    }
    Arrays.sort(arr2);
    int[] diff = new int[c-1];
    for(int j = 1; j < arr2.length; j++){
      diff[j-1] = arr2[j] - arr2[j-1] - 1;
    }
    Arrays.sort(diff);
    out.println(minStall(m, arr2, diff));
    out.close();
  }

  public static int minStall(int m, int[] arr, int[] diff){
    int total = 0;
    for(int i = diff.length-1; i > diff.length - m; i--){
      if(i >= 0)
        total += diff[i];
    }
    return arr[arr.length-1] - arr[0] + 1 - total;
  }
}
