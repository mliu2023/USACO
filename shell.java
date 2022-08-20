import java.util.*;
import java.io.*;
public class shell{
  public static int n;
  public static int[][] swap;
  public static int game(int a){
    boolean[] shell = new boolean[4];
    int counter = 0;
    shell[a]=true;
    for(int i = 0; i < n; i++){
      boolean temp = shell[swap[i][0]];
      shell[swap[i][0]]=shell[swap[i][1]];
      shell[swap[i][1]] = temp;
      if(shell[swap[i][2]]){counter++;}
    }
    return counter;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("shell.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
    n = Integer.parseInt(f.readLine());
    swap = new int[n][3];
    for(int i = 0; i < n; i++){
      String[] arr = f.readLine().split(" ");
      swap[i][0]=Integer.parseInt(arr[0]);
      swap[i][1]=Integer.parseInt(arr[1]);
      swap[i][2]=Integer.parseInt(arr[2]);
    }
    int x = game(1);
    int y = game(2);
    int z = game(3);
    int b = Math.max(x,y);
    int c = Math.max(b,z);
    out.println(c);
    out.close();
  }
}
