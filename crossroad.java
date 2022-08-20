import java.util.*;
import java.io.*;
public class crossroad{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("crossroad.in"));
    PrintWriter out = new PrintWriter(new FileWriter("crossroad.out"));

    int n = Integer.parseInt(f.readLine());
    int[] sides = new int[11];
    int ans = 0;
    for(int i = 0; i < n; i++){
      String line = f.readLine();
      String[] parts = line.split(" ");
      int cow = Integer.parseInt(parts[0]);
      int newSide = Integer.parseInt(parts[1]);
      if(newSide == 0){
        newSide = -1;
      }
      if(sides[cow] != 0 && sides[cow] != newSide){
        ans++;
      }
      sides[cow] = newSide;
    }
    out.println(ans);
    out.close();
  }
}
