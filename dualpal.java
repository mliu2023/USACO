/*
ID: maximus9
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.*;

public class dualpal{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
    String[] arr = f.readLine().split(" ");
    int n = Integer.parseInt(arr[0]);
    int S = Integer.parseInt(arr[1]);
    S = S + 1;
    while(n > 0){
      if(check2(S)){
        out.println(S);
        n--;
      }
      S++;
    }
    out.close();
  }

  public static String convertBase(int n, int b){
    if(n == 0){
      return "";
    }
    else{
      return (convertBase(n/b, b) + (n % b));
    }
  }

  public static boolean isPal(String s){
    if(s.length() <= 1){
      return true;
    }
    else{
      if(s.substring(0, 1).equals(s.substring(s.length()-1))){
        return isPal(s.substring(1, s.length()-1));
      }
    }
    return false;
  }

  public static boolean check2(int n){
    int counter = 0;
    for(int b = 2; b <= 10; b++){
      if(isPal(convertBase(n, b))){
        counter++;
      }
    }
    if (counter >= 2){
      return true;
    }
    return false;
  }
}
