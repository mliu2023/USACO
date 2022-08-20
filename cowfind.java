import java.util.*;
import java.io.*;

public class cowfind{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("cowfind.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowfind.out")));
    String s = f.readLine();
    int total = 0;
    ArrayList<Integer> open = new ArrayList<Integer>();
    ArrayList<Integer> close = new ArrayList<Integer>();
    open = count2("((", s, open);
    close = count2("))", s, close);
    for(int i = 0; i < open.size(); i++){
      for(int j = 0; j < close.size(); j++){
        if(open.get(i) < close.get(j))
          total += 1;
      }
    }
    out.println(total);
    out.close();
  }

  public static int count(String k, String s){
    if(s.indexOf(k) == -1){
      return 0;
    }
    else{
      int index = s.indexOf(k);
      return 1 + count(k, s.substring(index+1));
    }
  }

  public static ArrayList<Integer> count2(String k, String s, ArrayList<Integer> arr){
    for(int i = 0; i < s.length()-1; i++){
      if(k.equals(s.substring(i, i+2))){
        arr.add(i);
      }
    }
    return arr;
  }
}
