/*
ID: maximus9
LANG: JAVA
TASK: namenum
*/


import java.io.*;
import java.util.*;

public class namenum{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
    BufferedReader f2 = new BufferedReader(new FileReader("dict.txt"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    String s = st.nextToken();
    ArrayList<String> arrL = new ArrayList<String>(550000);
    arrL.add("");
    String[][] arr = {
      {"A", "B", "C"},
      {"D", "E", "F"},
      {"G", "H", "I"},
      {"J", "K", "L"},
      {"M", "N", "O"},
      {"P", "R", "S"},
      {"T", "U", "V"},
      {"W", "X", "Y"}
    };
    ArrayList<String> input = new ArrayList<String>(20);
    String inputLine = "";
    String line;
    while((line = f2.readLine()) != null){
      if(s.length() == line.length()){
        input.add(line);
        inputLine += line;
      }
    }
    ArrayList<String> names = generateName(s, arr, arrL, inputLine);
    boolean x = true;
    for(int i = 0; i < names.size(); i++){
      if(input.indexOf(names.get(i)) >= 0){
        out.println(names.get(i));
        x = false;
      }
    }
    if(x){
      out.println("NONE");
    }
    out.close();
    System.exit(0);
  }

  public static ArrayList<String> generateName(String s, String[][] arr, ArrayList<String> names, String inputLine){
    if(s.length() == 0){
      return names;
    }
    else{
      int k = names.size();
      for(int i = 0; i < k; i++){
        for(int j = 0; j < 3; j++){
          if(inputLine.indexOf(names.get(0) + arr[Integer.parseInt(s.substring(0, 1)) - 2][j]) >= 0)
            names.add(names.get(0) + arr[Integer.parseInt(s.substring(0, 1)) - 2][j]);
        }
        names.remove(0);
      }
      return generateName(s.substring(1), arr, names, inputLine);
  }
}

}
