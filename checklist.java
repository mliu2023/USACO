import java.io.*;
import java.util.*;
public class checklist{
  public static int h;
  public static int g;
  public static int[][] hArr;
  public static int[][] gArr;
  public static int[][][] memo;
  public static int calc(int x, int y){
    return (hArr[x][0]-gArr[y][0])*(hArr[x][0]-gArr[y][0])+(hArr[x][1]-gArr[y][1])*(hArr[x][1]-gArr[y][1]);
  }
  public static int dp(int a, int b, int total, int prev){
    if(a == h-1 && b == g-1){
      return total;
    }
    else if(memo[a][b][prev] != 0){
      return memo[a][b][prev];
    }
    else if(a == h-1){
      return memo[a][b][0] = dp(a, b+1, total+calc(a,b), 0);
    }
    else if(b == h-1){
      return memo[a][b][1] = dp(a+1, b, total+calc(a,b), 1);
    }
    else{
      return Math.min(memo[a][b][0] = dp(a, b+1, total+calc(a,b), 0), memo[a][b][1] = dp(a+1, b, total+calc(a,b), 1));
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("checklist.in"));
    PrintWriter out = new PrintWriter(new FileWriter("checklist.out"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    h = Integer.parseInt(st.nextToken());
    g = Integer.parseInt(st.nextToken());
    hArr = new int[h][2];
    gArr = new int[g][2];
    memo = new int[h][g][2];
    for(int i = 0; i < h; i++){
      st = new StringTokenizer(f.readLine());
      hArr[i][0] = Integer.parseInt(st.nextToken());
      hArr[i][1] = Integer.parseInt(st.nextToken());
    }
    for(int j = 0; j < g; j++){
      st = new StringTokenizer(f.readLine());
      hArr[j][0] = Integer.parseInt(st.nextToken());
      hArr[j][1] = Integer.parseInt(st.nextToken());
    }
    System.out.println(Math.min(dp(0,0,0,0), dp(0,0,0,1)));
  }
}
