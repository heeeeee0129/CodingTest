import java.util.*;
import java.io.*;

public class Solution {
    public static int t;
    public static int n;
    public static int m;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(in.readLine());
        StringTokenizer st;

        for(int test_case = 1;test_case<=t ; test_case++){
          st = new StringTokenizer(in.readLine());
          n = Integer.parseInt(st.nextToken());
          m = Integer.parseInt(st.nextToken());
          if(test(m)) {
            System.out.println("#"+test_case+ " ON");
          }else{
            System.out.println("#"+test_case+" OFF");
          }

        }
    }
    

    public static boolean test(int number){
      int mask = (1 << n) - 1;
      return (number & mask) == mask;
    }

}