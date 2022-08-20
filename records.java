import java.util.*;
import java.io.*;
public class records{
  public static boolean isSame(String a, String b){
    String[] bArr = b.split(" ");
    for(int i = 0; i < 3; i++){
      if(a.indexOf(bArr[i])==-1){
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("records.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("records.out")));
    int n = Integer.parseInt(f.readLine());
    String line;
    ArrayList<String> input = new ArrayList<String>(1000);
    while((line=f.readLine()) != null){
      input.add(line);
    }
    int max = 0;
    for(int i = 0; i < n; i++){
      int counter = 0;
      for(int j = 0; j < n; j++){
        if(isSame(input.get(i), input.get(j))){
          counter++;
        }
      }
      if(counter>max){
        max=counter;
      }
    }
    out.println(max);
    out.close();
  }
}
