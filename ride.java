/*
ID: maximus9
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;
public class ride {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    String i1 = f.readLine();
    String i2 = f.readLine();
    int total1 = 1;
    int total2 = 1;
    for(int i = 0; i < i1.length(); i++){
      char x = i1.charAt(i);
      total1 *= ((int)x - 64);
    }
    for(int j = 0; j < i2.length(); j++){
      char y = i2.charAt(j);
      total2 *= ((int)y - 64);
    }
    if(total1 % 47 == total2 % 47){
      out.println("GO");
    }
    else{
      out.println("STAY");
    }
    out.close();
  }
}
