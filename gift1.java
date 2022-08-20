/*
ID: maximus9
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    ArrayList<String> input = new ArrayList<String>(100);
    String line;
    while((line = f.readLine()) != null){
      input.add(line);
    }
    int number = Integer.parseInt(input.get(0));
    int[] money = new int[10];
    ArrayList<String> people = new ArrayList<String>(10);
    for(int i = 0; i < number; i++){
      people.add(input.get(i+1));
    }
    for(int j = number+1; j < input.size(); j += 2){
      int person = people.indexOf(input.get(j));
      String amounts = input.get(j+1);
      String[] n2 = amounts.split(" ");
      int i1 = Integer.parseInt(n2[0]);
      int i2 = Integer.parseInt(n2[1]);
      if(i2 != 0){
        int give = i1/i2;
        for(int k = j+2; k <= j+1+i2; k++){
          int index1 = people.indexOf(input.get(k));
          money[index1] += give;
        }
        money[person] -= i1;
        money[person] += i1 % i2;
        j += i2;
      }
      else{
        money[person] += i1;
      }
    }
    for(int m = 0; m < number; m++){
      out.print(people.get(m));
      out.println(" " + money[m]);
    }
    out.close();
  }
}
