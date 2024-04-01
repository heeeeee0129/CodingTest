import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class Solution {
	
	static int max_idx = 0;
	static List<Long> factorial = new ArrayList<>(); 
	
	static int p = 1234567891;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int t = Integer.parseInt(st.nextToken());
		factorial.add(1L);
		for(int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			if(n > max_idx) {
				for(int i = max_idx+1; i<=n; i++) {
					factorial.add(factorial.get(i-1)*i%p);
				}
			}
			max_idx = n;
			System.out.println("#" + test_case + " " + (factorial.get(n)*power((long)factorial.get(n-r)*factorial.get(r), p-2))%p);
			
		}
	}
	
	private static long power(long a, int n) {
		
		long result = 1L;
		a = a % p;
		while(n > 0) {
			if(n%2==1) {
				result  = (result * a) % p;
			}
			a  = (a * (long) a) % p;
			n = n >> 1;
		}
		return result;
	}
	
	
	
	
}