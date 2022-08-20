// make sure to import these two things
import java.io.*;
import java.util.*;
// name the file whatever you want
public class daisy{
  // main method needs to throw IOException
  public static void main(String[] args) throws IOException{
    // f will read the input
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    // st converts the next line (f.readLine()) into tokens, which you can access with st.nextToken()
    StringTokenizer st = new StringTokenizer(f.readLine());
    // there is only one token on this line, and we read this into n.
    // Integer.parseInt(String str) will turn the String into an int/Integer.
    // Integer.parseInt(String str) will throw an exception if str is not a number.
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];

    // this tokenizes the next line.
    st = new StringTokenizer(f.readLine());
    for(int i = 0; i < n; i++){
      // st.nextToken() gets the next token on the line.
      // Integer.parseInt() turns it into an int.
      arr[i] = Integer.parseInt(st.nextToken());
    }
    // now, we're done reading in the input into the array.
    // (don't worry if you don't understand the actual code below)
    // no need to comment on actual contests either

    // ans will keep track of the answer.
    int ans = 0;
    // l iterates over the different lengths
    for(int l = 1; l <= n; l++){
      // k iterates over the starting points
      for(int k = 0; k <= n-l; k++){
        int total = 0;
        // m iterates over the interval and adds to the total.
        for(int m = k; m < k+l; m++){
          total += arr[m];
        }
        // r iterates over the interval and checks for an average flower.
        for(int r = k; r < k+l; r++){
          if(l*arr[r] == total){
            ans++;
            break;
          }
        }
      }
    }
    // print your answer like you would to the terminal.
    System.out.println(ans);
  }
}
