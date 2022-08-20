import java.util.*;
import java.io.*;
public class baseball{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("baseball.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("baseball.out")));
    int n = Integer.parseInt(f.readLine());
    int[] arr = new int[n];
    for(int a = 0; a < n; a++){
      arr[a]=Integer.parseInt(f.readLine());
    }
    Arrays.sort(arr);
    int counter = 0;
    for(int i = 0; i < n-2; i++){
      for(int j = i+1; j < n-1; j++){
        for(int k = i+2; k < n; k++){
          if(arr[k]-arr[j]>=arr[j]-arr[i] && arr[k]-arr[j]<=2*(arr[j]-arr[i])){
            counter++;
          }
        }
      }
    }
    out.println(counter);
    out.close();
  }
}
