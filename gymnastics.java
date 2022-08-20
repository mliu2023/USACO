import java.io.*;
import java.util.*;

public class gymnastics{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
    ArrayList<String> input = new ArrayList<String>(50);
    String line;
    while((line = f.readLine()) != null){
      input.add(line);
    }
    String[] numbers = input.get(0).split(" ");
    int k = Integer.parseInt(numbers[0]);
    int n = Integer.parseInt(numbers[1]);
    int counter = 0;
    for(int i = 1; i <= n; i++){
      for(int j = 1; j < i; j++){
        if(check(i, j, k, input) || check(j, i, k, input)){
          counter++;
        }
      }
    }
    out.print(counter);
    out.close();
  }
  public static boolean check(int i, int j, int k, ArrayList<String> input){
    for(int m = 1; m <= k; m++){
      String s = input.get(m);
      String[] arr = s.split(" ");
      ArrayList<String> arr2 = new ArrayList<String>(20);
      for(int z = 0; z < arr.length; z++){
        arr2.add(arr[z]);
      }
      if(arr2.indexOf(Integer.toString(i)) < arr2.indexOf(Integer.toString(j))){
        return false;
      }
    }
    return true;
  }

}
