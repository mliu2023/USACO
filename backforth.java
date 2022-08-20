import java.util.*;
import java.io.*;
public class backforth{
  public static ArrayList<Integer> b1 = new ArrayList<Integer>(10);
  public static ArrayList<Integer> b2 = new ArrayList<Integer>(10);
  public static int total1 = 1000;
  public static int total2 = 1000;
  public static int day = 0;
  public static int number = 0;
  public static ArrayList<Integer> sols = new ArrayList<Integer>();
  public static void solve(){
    if(day == 4){
      if(sols.indexOf(total1)==-1){
        sols.add(total1);
        number++;
      }
    }
    else{
      if(day%2==0){
        for(int i = 0; i < b1.size(); i++){
          int a = b1.get(i);
          total1 -= a;
          b2.add(b1.remove(i));
          day++;
          solve();
          day--;
          b1.add(i, b2.remove(b2.size()-1));
          total1 += a;
        }
      }
      else{
        for(int j = 0; j < b2.size(); j++){
          int b = b2.get(j);
          total1 += b;
          b1.add(b2.remove(j));
          day++;
          solve();
          day--;
          b2.add(j, b1.remove(b1.size()-1));
          total1 -= b;
        }
      }
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
    String[] arr1 = f.readLine().split(" ");
    String[] arr2 = f.readLine().split(" ");
    for(String x: arr1){
      b1.add(Integer.parseInt(x));
    }
    for(String x: arr2){
      b2.add(Integer.parseInt(x));
    }
    solve();
    out.println(number);
    out.close();
  }
}
