import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;



public class Main {
	static int p = 1000000000;
	static HashMap<Long, Long> memo = new HashMap<>(); //메모이제이션
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		System.out.println((fibo(b+2)-fibo(a+1)+p)%p);
	}
	
	private static long fibo(long n) {
		if (n == 0) {
			return 0;
		}
		if (n==1) {
			return 1;
		}
		if(memo.containsKey(n)) {
			return memo.get(n);
		}
		long x, y;
		if(n%2 == 0) {
			 x = fibo(n/2);
			 y = fibo(n/2-1);
			 memo.put(n, (x*x + 2*x*y)%p);
			return (x*x + 2*x*y)%p;
		}else {
			 x = fibo(n/2+1);
			 y = fibo(n/2);
			 memo.put(n, (x*x + y*y)%p);
			return (x*x + y*y)%p;
		}
		
	}
	
}