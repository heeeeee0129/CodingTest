import java.util.*;
import java.io.*;

public class Main {
    public static int[][][] dp;
    public static int t;
    public static int w;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        dp = new int[t+1][2][w+1]; // [지난 시간][현재 위치][남은 이동 횟수]

       
        for(int j = 0; j <= w; j++){
            dp[0][0][j] = 1;
        }
        dp[0][1][0] = 0;

        for(int i = 1; i<=t; i++){
            int tree = Integer.parseInt(in.readLine());

            for(int j = 0; j <= w; j++){
                if(tree == 1){
                    if(j == 0){
                        dp[i][0][j] = Math.max(0,dp[i-1][0][j]+1);
                        dp[i][1][j] = Math.max(0, dp[i-1][1][j]);
                    }else{
                        dp[i][0][j] = Math.max(dp[i-1][1][j-1]+1,dp[i-1][0][j]+1);
                        dp[i][1][j] = Math.max(dp[i-1][0][j-1], dp[i-1][1][j]);
                    }
                }else{
                    if(j == 0){
                        dp[i][1][j] = Math.max(0,dp[i-1][1][j]+1);
                        dp[i][0][j] = Math.max(0, dp[i-1][0][j]);
                    }else{
                        dp[i][1][j] = Math.max(dp[i-1][0][j-1]+1,dp[i-1][1][j]+1);
                        dp[i][0][j] = Math.max(dp[i-1][1][j-1], dp[i-1][0][j]);
                    }
                }
            }
        }

        int result = 0;
        for(int j = 0; j<= w; j++){
            result = Math.max(result, dp[t][0][w]);
            result = Math.max(result, dp[t][1][w]);
        }
        

        System.out.print(result-1);


    }
}