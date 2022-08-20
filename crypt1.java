/*
ID: maximus9
LANG: JAVA
TASK: crypt1
*/

import java.io.*;
import java.util.*;

public class crypt1{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
    int n = Integer.parseInt(f.readLine());
    String[] nums = f.readLine().split(" ");
    ArrayList<Integer> set = new ArrayList<Integer>();
    for(int i = 0; i < nums.length; i++){
      set.add(Integer.parseInt(nums[i]));
    }
    int counter = 0;
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(0);
    arr = generate(set, 5, arr);
    for(int j = 0; j < arr.size(); j++){
      if(check(arr.get(j), set)){
        counter++;
      }
    }
    out.println(counter);
    out.close();
  }
    public static ArrayList<Integer> generate(ArrayList<Integer> set, int length, ArrayList<Integer> arr){
      if(length == 0){
        return arr;
      }
      int k = arr.size();
      for(int i = 0; i < k; i++){
        for(int j = 0; j < set.size(); j++){
          arr.add(10 * arr.get(0) + set.get(j));
        }
        arr.remove(0);
      }
      return generate(set, length-1, arr);
    }

    public static boolean check(int n, ArrayList<Integer> arr){
      int first3 = n/100;
      int last = n % 10;
      int last2 = (n/10)%10;
      int product1 = first3 * last;
      int product2 = first3 * last2;
      int product3 = first3 * (n%100);
      if(!checkDigits(product1, arr)){
        return false;
      }
      else if(!checkDigits(product2, arr)){
        return false;
      }
      else if(!checkDigits(product3, arr)){
        return false;
      }
      else if(product1/1000 != 0 || product1/100 == 0){
        return false;
      }
      else if(product2/1000 != 0 || product2/100 == 0){
        return false;
      }
      else if(product3/10000 != 0 || product3/1000 == 0){
        return false;
      }
      return true;
    }

    public static boolean checkDigits(int n, ArrayList<Integer> arr){
      while(n > 0){
        if(arr.indexOf(n%10) == -1){
          return false;
        }
        n = n/10;
      }
      return true;
    }

}
