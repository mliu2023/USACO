import java.io.*;
import java.util.*;

public class greetings{
  public static ArrayList<Integer> bpos = new ArrayList<Integer>();
  public static ArrayList<Integer> epos = new ArrayList<Integer>();
  public static ArrayList<Integer> relative = new ArrayList<Integer>();
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("greetings.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("greetings.out")));
    String[] nums = f.readLine().split(" ");
    int b = Integer.parseInt(nums[0]);
    int e = Integer.parseInt(nums[1]);
    bpos.add(0);
    epos.add(0);
    for(int i = 0; i < b; i++){
      String[] arr = f.readLine().split(" ");
      for(int k = 0; k < Integer.parseInt(arr[0]); k++){
        if(arr[1].equals("L"))
          bpos.add(bpos.get(bpos.size()-1)-1);
        else
          bpos.add(bpos.get(bpos.size()-1)+1);
      }
    }
    for(int j = 0; j < e; j++){
      String[] arr2 = f.readLine().split(" ");
      for(int l = 0; l < Integer.parseInt(arr2[0]); l++){
        if(arr2[1].equals("L"))
          epos.add(epos.get(epos.size()-1)-1);
        else
          epos.add(epos.get(epos.size()-1)+1);
      }
    }
    while(bpos.size()>epos.size()){
      epos.add(epos.get(epos.size()-1));
    }
    while(epos.size()>bpos.size()){
      bpos.add(bpos.get(bpos.size()-1));
    }
    for(int a = 0; a < bpos.size(); a++){
      relative.add(bpos.get(a)-epos.get(a));
    }
    int counter = 0;
    for(int z = 1; z < relative.size()-1; z++){
      if(relative.get(z)==0){
        if(relative.get(z-1)!=0){
          counter++;}
      }
      else if(relative.get(z)+relative.get(z+1)==0){
        counter++;
      }
    }
    if(relative.get(relative.size()-1)==0){
      counter++;
    }
    out.println(counter);
    out.close();
  }
}
