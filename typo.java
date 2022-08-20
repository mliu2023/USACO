import java.io.*;
import java.util.*;

public class typo{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("typo.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("typo.out")));
    String s = f.readLine();
    int counter = 0;
    int openingSeen = 0;
    int closingSeen = 0;
    boolean x = true;
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) == '('){
        counter++;
        openingSeen++;}
      else{
        counter--;
        closingSeen++;}
      if(counter == 1){
        openingSeen = 0;
      }
      if(counter == -1){
        out.println(closingSeen);
        x = false;
        break;
      }
    }
    if(x){
      out.println(openingSeen);
    }
    out.close();
  }

}
