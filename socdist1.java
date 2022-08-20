import java.io.*;
import java.util.*;
public class socdist1{

  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("socdist1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
    int n = Integer.parseInt(f.readLine());
    String s = f.readLine();
    int end = 0;
    for(int j = n-1; j > -1; j--){
      if(s.substring(j, j+1).equals("1")){
        end = n-j-1;
        break;
      }
    }
    int counter = 1;
    int maxCounter1 = 1;
    int maxCounter2 = 1;
    int minCounter = n;
    for(int i = 0; i < n; i++){
      if(s.substring(i, i+1).equals("0")){
        counter++;
      }
      else{
        if(counter < minCounter && i > s.indexOf("1")){
          minCounter = counter;
        }
        counter = 1;
      }
      if(counter > maxCounter1){
        if(i > s.indexOf("1"))
          maxCounter1 = counter;
        else
          maxCounter1 = counter+1;
      }
      else if(counter > maxCounter2){
        if(i > s.indexOf("1"))
          maxCounter2 = counter;
        else
          maxCounter2 = counter+1;
      }
    }
    out.println(Math.min(Math.max(Math.max(maxCounter1/3, maxCounter2/2), Math.max(maxCounter1/2, Math.min(s.indexOf("1"), end))), minCounter));
    out.close();
  }
}
