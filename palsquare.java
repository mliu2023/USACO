/*
ID: maximus9
LANG: JAVA
TASK: palsquare
*/

import java.io.*;
import java.util.*;

public class palsquare{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
    int b = Integer.parseInt(f.readLine());
    for(int i = 1; i <= 300; i++){
      int i2 = i * i;
      String s2 = convertBase(b, i2);
      if(check(s2)){
        out.print(convertBase(b, i) + " ");
        out.println(s2);
      }
    }
    out.close();

  }

  public static String convertBase(int b, int n){
    String t = "";
    int powerCounter = maxPower(b, n);
    for(int i = powerCounter; i >= 0; i--){
      int counter = 0;
      while(n - Math.pow(b, i) >= 0 && counter < b-1){
        n -= Math.pow(b, i);
        counter++;
      }
      if(counter >= 10){
        char x = (char)(counter+55);
        t += x;
      }
      else{
        String x = Integer.toString(counter);
        t += x;
      }
    }
    return t;
  }

  public static boolean check(String s){
    if(s.length() <= 1){
      return true;
    }
    else if(s.substring(0,1).equals(s.substring(s.length()-1))){
      return check(s.substring(1, s.length()-1));
    }
    else{
      return false;
    }
  }

  public static int maxPower(int b, int n){
    int k = 0;
    while(Math.pow(b, k)*b <= n){
      k++;
    }
    return k;
  }
}
