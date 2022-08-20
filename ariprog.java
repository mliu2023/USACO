/*
ID: maximus9
LANG: JAVA
TASK: ariprog
*/
import java.io.*;
import java.util.*;

public class ariprog{
  public static int n;
  public static int m;
  public static boolean[] isBisquare;
  public static boolean checkSequence(int a, int d){
    for(int i = 0; i < n; i++){
      if(isBisquare[a+d*i]==false){
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
    n = Integer.parseInt(f.readLine());
    m = Integer.parseInt(f.readLine());
    isBisquare = new boolean[2*m*m+1];
    for(int i = 0; i <= m; i++){
      for(int j = 0; j <= i; j++){
        isBisquare[i*i+j*j]=true;
      }
    }
    boolean x = true;
    for(int d = 1; d <= 2*m*m; d++){
      for(int a = 0; a+d*(n-1) <= 2*m*m; a++){
        if(checkSequence(a,d)){
          out.println(a + " " + d);
          x=false;
        }
      }
    }
    if(x){
      out.println("NONE");
    }
    out.close();
  }
}
