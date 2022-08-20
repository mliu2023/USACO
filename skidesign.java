/*
ID: maximus9
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
import java.util.*;

public class skidesign{
  public static int calculate(int k, int[] hills){
    int total = 0;
    for(int i = 0; i < hills.length; i++){
      int x = hills[i];
      if(x<k)
        total += (k-x)*(k-x);
      if(x>k+17)
        total += (x-k-17)*(x-k-17);
    }
    return total;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
    int n = Integer.parseInt(f.readLine());
    int[] hills = new int[n];
    int min = 100;
    int max = 0;
    for(int i = 0; i < n; i++){
      int x = Integer.parseInt(f.readLine());
      hills[i] = x;
      if(x>max)
        max=x;
      if(x<min)
        min=x;
    }
    int mintotal = Integer.MAX_VALUE;
    int temp;
    for(int j = min; j <= max; j++){
      if((temp = calculate(j, hills)) < mintotal)
        mintotal=temp;
    }
    out.println(mintotal);
    out.close();
  }
}
