import java.io.*;
import java.util.*;
public class comfort{
  public static int[][] arr;
  public static int n;
  public static int count = 0;
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(f.readLine());
    n = Integer.parseInt(st.nextToken());
    arr = new int[2000][2000];
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(f.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x = 1500-y1;
      int y = x1+500;
      if(arr[x][y]==2){
        count--;
      }
      arr[x][y] = 1;
      add(x,y);
      System.out.println(count);
      //for(int a = 0; a < 20; a++){
      //  System.out.println(Arrays.toString(arr[a]));
      //}
    }
  }
  public static int calcComfort(int x, int y){
    return (arr[x-1][y]+1)/2+(arr[x+1][y]+1)/2+(arr[x][y+1]+1)/2+(arr[x][y-1]+1)/2;
  }
  public static void add(int x, int y){
    if(arr[x][y] == 0){
      arr[x][y] = 2;
    }
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    for(int j = 0; j < 4; j++){
      if(arr[x+dx[j]][y+dy[j]] != 0 && calcComfort(x+dx[j],y+dy[j])==3){
        for(int i = 0; i < 4; i++){
          if(arr[x+dx[j]+dx[i]][y+dy[j]+dy[i]]==0){
            count++;
            add(x+dx[j]+dx[i],y+dy[j]+dy[i]);
            break;
          }
        }
      }
    }
  }
}
