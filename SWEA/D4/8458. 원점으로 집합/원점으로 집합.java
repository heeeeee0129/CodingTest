import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case<=t; test_case++) {
			int max_count = 0;
			int n = Integer.parseInt(in.readLine());
			int[] dist = new int[n];
			int max_dist = 0;
			int flag = 0;
			
			for(int i = 0; i< n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				dist[i] = Math.abs(Integer.parseInt(st.nextToken()))+Math.abs(Integer.parseInt(st.nextToken()));
				flag += dist[i]%2;
				max_dist = Math.max(max_dist, dist[i]);
			}
			
			int result = -1;
			if(flag == 0 || flag == n) {
				int idx = 0;
				int sum_dist = 0;
				while(true) {
					sum_dist += idx;
					if(sum_dist >= max_dist && (sum_dist-max_dist)%2 == 0) {
						result = idx;
						break;
					}
					idx++;
				}
			}
				
			
			System.out.println("#" +test_case+" "+result);
			
		}
		
	}
}