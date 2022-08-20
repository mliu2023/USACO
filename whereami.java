import java.io.*;
import java.util.*;

public class whereami{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
    ArrayList<String> input = new ArrayList<String>(2);
    String line;
    while((line = f.readLine()) != null){
      input.add(line);
    }
    int n = Integer.parseInt(input.get(0));
    String sequence = input.get(1);
    int l = sequence.length();
    int least = findLeast(n, l, sequence);
    out.print(least);
    out.close();
  }

  public static boolean checkLength(int n, int l, String s){
    ArrayList<String> arr = new ArrayList<String>(26);
    for(int a = 0; a <= n-l; a++){
      arr.add(s.substring(a, a+l));
    }
    for(int b = 0; b < arr.size(); b++){
      for(int c = 0; c < b; c++){
        if(arr.get(b).equals(arr.get(c))){
          return false;
        }
      }
    }
    return true;
  }

  public static int findLeast(int n, int l, String s){
    for(int length = 1; length <= l; length++){
      if(checkLength(n, length, s)){
        return length;
      }
    }
    return l;
  }
}
