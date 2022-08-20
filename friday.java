/*
ID: maximus9
LANG: JAVA
TASK: friday
*/

import java.io.*;
import java.util.*;
public class friday{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    int n = Integer.parseInt(f.readLine());
    int[] count = new int[7];
    int day = 2;
    int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    for(int i = 1900; i < 1900+n; i++){
      if(i % 4 == 0){
        if(i % 100 != 0 || i % 400 == 0){
          months[1] = 29;
        }
      }
      else{
        months[1] = 28;
      }
      for(int j = 0; j < 12; j++){
        for(int k = 1; k <= months[j]; k++){
          if(k == 13){
            count[day] += 1;
          }
          day = (day + 1) % 7;
        }
      }
    }
    for(int m = 0; m < 6; m++){
      out.print(count[m] + " ");
    }
      out.print(count[6]);
    out.println();
    out.close();
  }
}
