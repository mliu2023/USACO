/*
ID: maximus9
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;
public class combo{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("combo.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
    int n = Integer.parseInt(f.readLine());
    String[] arr = f.readLine().split(" ");
    int[] farmer = {Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2])};
    String[] arr2 = f.readLine().split(" ");
    int[] master = {Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1]), Integer.parseInt(arr2[2])};
    int counter = 0;
    for(int i = 0; i < n; i++){
      if(Math.min(Math.abs(farmer[0]-i), n-Math.abs(farmer[0]-i))<=2 && Math.min(Math.abs(master[0]-i), n-Math.abs(master[0]-i))<=2){
        for(int j = 0; j < n; j++){
          if(Math.min(Math.abs(farmer[1]-j), n-Math.abs(farmer[1]-j))<=2 && Math.min(Math.abs(master[1]-j), n-Math.abs(master[1]-j))<=2){
            for(int k = 0; k < n; k++){
              if(Math.min(Math.abs(farmer[2]-k), n-Math.abs(farmer[2]-k))<=2 && Math.min(Math.abs(master[2]-k), n-Math.abs(master[2]-k))<=2)
                counter++;
            }
          }
        }
      }
    }
    if(n >= 5){
      out.println(250-counter);
    }
    else{
      out.println(2*n*n*n-counter);
    }
    out.close();
  }
}
