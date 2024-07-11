import java.util.*;
import java.io.*;


public class Main {
    public static int n;
    public static int m;
    public static int[][] candys;
    public static int[] knapsack;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Math.round(100 * Float.parseFloat(st.nextToken()));
            if(n == 0 && m == 0){
                break;
            }
            candys = new int[n][2];
            knapsack = new int[m+1];
            for(int i = 0; i<n; i++){
                st = new StringTokenizer(in.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = Math.round(100 * Float.parseFloat(st.nextToken()));
                if(p>m)continue;
                for(int j = p; j < m+1; ++j){
                    knapsack[j] = Math.max(knapsack[j], knapsack[j-p]+c);
                }
            }
            System.out.println(knapsack[m]);
            
        }
        
    }
}