/*
ID: maximus9
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;
public class beads{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    int number = Integer.parseInt(f.readLine());
    String necklace = f.readLine();
    String necklace2 = necklace + necklace;
    int a;
    int maxLength = 0;
    for(int i = 0; i < necklace.length(); i++){
      String s = necklace2.substring(i, i+number);
      if((a = length(s)) > maxLength){
        maxLength = a;
      }
    }
    out.println(maxLength);
    out.close();
  }
  public static int length(String s){
    if(s.indexOf("r") < 0)
      return s.length();
    else if(s.indexOf("b") < 0)
      return s.length();
    else{
      int bindex = s.indexOf("b");
      int rindex = s.indexOf("r");
      if(rindex>bindex){
        if(s.substring(rindex).indexOf("b") < 0)
          return s.length();
        else
          return rindex + s.substring(rindex).indexOf("b");
      }
      else{
        if(s.substring(bindex).indexOf("r") < 0)
          return s.length();
        else
          return bindex + s.substring(bindex).indexOf("r");
      }
    }
  }

}
