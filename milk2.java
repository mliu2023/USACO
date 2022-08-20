/*
ID: maximus9
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

public class milk2{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
    String line;
    int n = Integer.parseInt(f.readLine());
    ArrayList<Integer> start = new ArrayList<Integer>(5000);
    ArrayList<Integer> end = new ArrayList<Integer>(5000);
    while((line = f.readLine()) != null){
      String arr[] = line.split(" ");
      start.add(Integer.parseInt(arr[0]));
      end.add(Integer.parseInt(arr[1]));
    }
    int minStart = 1000000;
    int maxEnd = 0;
    for(int a = 0; a < start.size(); a++){
      if(start.get(a) < minStart)
        minStart = start.get(a);
    }
    for(int b = 0; b < end.size(); b++){
      if(end.get(b) > maxEnd)
        maxEnd = end.get(b);
    }
    int maxMilk = 0;
    int counter1 = 0;
    int noMilk = 0;
    int counter2 = 0;
    for(int j = minStart; j < maxEnd; j++){
      if(check2(j, start, end)){
        counter1++;
        counter2 = 0;
        if(counter1 > maxMilk){
          maxMilk = counter1;
        }
      }
      else{
        counter2++;
        counter1 = 0;
        if(counter2 > noMilk){
          noMilk = counter2;
        }
      }
    }
    out.println(maxMilk + " " + noMilk);
    out.close();
  }

  public static boolean check(int x, ArrayList<Integer> start, ArrayList<Integer> end){
    int counterm = 0;
    int counterk = 0;
    for(int m = 0; m < start.size(); m++){
      if(start.get(m) <= x){
        counterm++;
      }
    }
    for(int k = 0; k < end.size(); k++){
      if(end.get(k) <= x){
        counterk++;
      }
    }
    if(counterm-counterk > 0){
      return true;
    }
    else{
      return false;
    }
  }

  public static boolean check2(int x, ArrayList<Integer> start, ArrayList<Integer> end){
    for(int i = 0; i < start.size(); i++){
      if(x >= start.get(i) && x < end.get(i))
        return true;
    }
    return false;
  }
}
