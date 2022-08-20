/*
ID: maximus9
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

public class milk{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("milk.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
    String line;
    String[] numbers = f.readLine().split(" ");
    int n = Integer.parseInt(numbers[0]);
    int m = Integer.parseInt(numbers[1]);
    ArrayList<Integer> prices = new ArrayList<Integer>(m);
    ArrayList<Integer> count = new ArrayList<Integer>(m);
    while((line = f.readLine()) != null){
      String[] nums = line.split(" ");
      prices.add(Integer.parseInt(nums[0]));
      count.add(Integer.parseInt(nums[1]));
    }
    out.println(minimizeCost(prices, count, n));
    out.close();
  }

  public static int minimizeCost(ArrayList<Integer> prices, ArrayList<Integer> count, int amount){
    if(amount == 0){
      return 0;
    }
    else if(amount == 1){
      while(count.get(prices.indexOf(minVal(prices))) <= 0){
        count.remove(prices.indexOf(minVal(prices)));
        prices.remove(prices.indexOf(minVal(prices)));
      }
      return minVal(prices);
    }
    else{
      while(count.get(prices.indexOf(minVal(prices))) <= 0){
        count.remove(prices.indexOf(minVal(prices)));
        prices.remove(prices.indexOf(minVal(prices)));
      }
      int min = minVal(prices);
      if(count.get(prices.indexOf(min)) <= amount){
        int hold = min * count.get(prices.indexOf(min));
        int hold2 = count.get(prices.indexOf(min));
        count.remove(prices.indexOf(min));
        prices.remove(prices.indexOf(min));
        return hold + minimizeCost(prices, count, amount-hold2);
      }
      count.set(prices.indexOf(min), count.get(prices.indexOf(min)) - 1);
      return min + minimizeCost(prices, count, amount-1);
    }
  }

  public static int minVal(ArrayList<Integer> arr){
    int minVal = Integer.MAX_VALUE;
    for(int i = 0; i < arr.size(); i++){
      if(arr.get(i) < minVal){
        minVal = arr.get(i);
      }
    }
    return minVal;
  }
}
