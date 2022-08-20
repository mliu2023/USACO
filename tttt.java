import java.util.*;
import java.io.*;
public class tttt{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("tttt.in"));
    PrintWriter out = new PrintWriter(new FileWriter("tttt.out"));
    String[][] arr = new String[3][3];
    int ans1 = 0;
    int ans2 = 0;
    String s1 = "";
    String s2 = 0;
    for(int i = 0; i < 3; i++){
      arr[i] = f.readLine().split("");
    }
    for(int r = 0; r < 3; r++){
      if(arr[r][0].equals(arr[r][1]) || arr[r][1].equals(arr[r][2]) || arr[r][0].equals(arr[r][2])){
        if(!arr[r][0].equals(arr[r][1]) || !arr[r][1].equals(arr[r][2]) || !arr[r][0].equals(arr[r][2])){
          if(s.indexOf(arr[r]) == -1){
            ans2++;
          }
          ans2++;
        }
        else{
          ans1++;
        }
      }
    }
    for(int c = 0; c < 3; c++){
      if(arr[0][c].equals(arr[1][c]) || arr[1][c].equals(arr[2][c]) || arr[0][c].equals(arr[2][c])){
        if(!arr[0][c].equals(arr[1][c]) || !arr[1][c].equals(arr[2][c]) || !arr[0][c].equals(arr[2][c])){
          ans2++;
        }
        else{
          ans1++;
        }
      }
    }
    if(arr[0][0].equals(arr[1][1]) || arr[1][1].equals(arr[2][2]) || arr[0][0].equals(arr[2][2])){
      if(!arr[0][0].equals(arr[1][1]) || !arr[1][1].equals(arr[2][2]) || !arr[0][0].equals(arr[2][2])){
        ans2++;
      }
      else{
        ans1++;
      }
    }
    if(arr[0][2].equals(arr[1][1]) || arr[1][1].equals(arr[2][0]) || arr[0][2].equals(arr[2][0])){
      if(!arr[0][2].equals(arr[1][1]) || !arr[1][1].equals(arr[2][0]) || !arr[0][2].equals(arr[2][0])){
        ans2++;
      }
      else{
        ans1++;
      }
    }
    out.println(ans1);
    out.println(ans2);
    out.close();
  }
}
