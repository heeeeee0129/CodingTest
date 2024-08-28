import java.io.*;
import java.util.*;


public class Main {
	static int[] dp;
	static int[] t;
	static int[] p;
	static int N;
    public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		dp = new int[N+1];
		dp[N] = 0;
		t = new int[N];
		p = new int[N];

		for(int i = 0; i<N; i++){
			st = new StringTokenizer(in.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=N-1; i >= 0; i--){
			if(i+t[i] <= N){
				int sum = dp[i+t[i]] + p[i];
				dp[i] = sum > dp[i+1] ? sum : dp[i+1];
			}else{
				dp[i] = dp[i+1];
			}
		}

		System.out.println(dp[0]);

    }
}