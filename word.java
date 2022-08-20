import java.util.*;
import java.io.*;
public class word{
  public static int n;
  public static int k;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("word.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
    String[] arr = f.readLine().split(" ");
    n = Integer.parseInt(arr[0]);
    k = Integer.parseInt(arr[1]);
    String[] words = f.readLine().split(" ");
    int counter = 0;
    for(int i = 0; i < n; i++){
      if(counter + words[i].length() > k)
      {
        out.println();
        counter = words[i].length();
        out.print(words[i]);
      }
      else
      {
        if(counter == 0){
          out.print(words[i]);
        }
        else{
          out.print(" " + words[i]);
        }
        counter += words[i].length();
      }

    }
    out.close();
  }
}
