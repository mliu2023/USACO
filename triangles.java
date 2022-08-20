import java.util.*;
import java.io.*;
public class triangles{
  public static int n;
  public static int[] xList = new int[100];
  public static int[] yList = new int[100];
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
    n = Integer.parseInt(f.readLine());
    for(int i = 0; i < n; i++){
      String[] nums = f.readLine().split(" ");
      xList[i]=Integer.parseInt(nums[0]);
      yList[i]=Integer.parseInt(nums[1]);
    }
    int maxArea = 0;
    for(int j = 0; j < n; j++){
      int xMax = 0;
      int yMax = 0;
      for(int k = 0; k < n; k++){
        if(xList[k]==xList[j]){
          yMax = Math.max(Math.abs(yList[j]-yList[k]), yMax);
        }
        else if(yList[k]==yList[j]){
          xMax = Math.max(Math.abs(xList[j]-xList[k]), xMax);
        }
      }
      maxArea = Math.max(maxArea, xMax*yMax);
    }
    out.println(maxArea);
    out.close();
  }
}
