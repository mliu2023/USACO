import java.io.*;
import java.util.*;
public class citystate{
  public static void main(String[] args) throws IOException{
    BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
    PrintWriter out = new PrintWriter(new FileWriter("citystate.out"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int n = Integer.parseInt(st.nextToken());
    HashMap<String, Long> h = new HashMap<String, Long>(200000);
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(f.readLine());
      String key = st.nextToken().substring(0,2);
      String val = st.nextToken();
      String str = key + val;
      if(h.containsKey(str)){
        h.replace(str, h.get(str)+1);
      }
      else{
        h.put(str, Long.valueOf(1));
      }
    }
    long total = 0;
    for(String k : h.keySet()){
      String s = k.substring(2, 4) + k.substring(0, 2);
      if(h.containsKey(s) && !k.substring(0,2).equals(k.substring(2,4))){
        total += h.get(s)*h.get(k);
      }
    }
    out.println(total/2);
    out.close();
  }
}
