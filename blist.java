import java.util.*;
import java.io.*;
public class blist{
  public static int n;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("blist.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
    n = Integer.parseInt(f.readLine());
    ArrayList<Integer> start = new ArrayList<Integer>(n);
    ArrayList<Integer> end = new ArrayList<Integer>(n);
    ArrayList<Integer> buckets = new ArrayList<Integer>(n);
    for(int i = 0; i < n; i++)
    {
      String[] nums = f.readLine().split(" ");
      start.add(Integer.parseInt(nums[0]));
      end.add(Integer.parseInt(nums[1]));
      buckets.add(Integer.parseInt(nums[2]));
    }
    int a;
    int totalBuckets=0;
    int maxBuckets = 0;
    for(int t = 1; t <= 1000; t++){
      if((a=start.indexOf(t))>=0){
        totalBuckets+=buckets.get(a);
      }
      if((a=end.indexOf(t))>=0){
        totalBuckets-=buckets.get(a);
      }
      if(totalBuckets>maxBuckets){
        maxBuckets=totalBuckets;
      }
    }
    out.println(maxBuckets);
    out.close();
  }
}
