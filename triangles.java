import java.util.*;
import java.io.*;
public class triangles{
  public static int n;
  public static int[] xList = new int[100000];
  public static int[] yList = new int[100000];
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
    n = Integer.parseInt(f.readLine());
    for(int i = 0; i < n; i++){
      String[] nums = f.readLine().split(" ");
      xList[i]=Integer.parseInt(nums[0]);
      yList[i]=Integer.parseInt(nums[1]);
    }
    int totalArea = 0;
    for(int j = 0; j < n; j++){
      int area = 0;
      int totalX = 0;
      int totalY = 0;
      for(int k = 0; k < n; k++){
        if(xList[k]==xList[j]){
          totalY += Math.abs(yList[k]-yList[j]);
        }
        else if(yList[k]==yList[j]){
          totalX += Math.abs(xList[k]-xList[j]);
        }
      }
      totalArea += totalX*totalY;
    }
    out.println(totalArea);
    out.close();
  }
}
