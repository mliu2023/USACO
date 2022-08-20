import java.io.*;
import java.util.*;
public class mixmilk{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("mixmilk.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
    String[] arr1 = f.readLine().split(" ");
    String[] arr2 = f.readLine().split(" ");
    String[] arr3 = f.readLine().split(" ");
    int[] size = {Integer.parseInt(arr1[0]), Integer.parseInt(arr2[0]), Integer.parseInt(arr3[0])};
    int[] amounts = {Integer.parseInt(arr1[1]), Integer.parseInt(arr2[1]), Integer.parseInt(arr3[1])};

    int counter = 0;
    while(counter < 100){
      int add1 = size[(counter+1)%3]-amounts[(counter+1)%3];
      int add2 = amounts[(counter)%3];
      int add = Math.min(add1, add2);
      amounts[(counter)%3] -= add;
      amounts[(counter+1)%3] += add;
      counter++;
    }
    out.println(amounts[0]);
    out.println(amounts[1]);
    out.println(amounts[2]);
    out.close();
  }
}
