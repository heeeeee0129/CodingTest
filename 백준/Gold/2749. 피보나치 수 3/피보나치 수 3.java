import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;



public class Main {
	static int p = 1000000;
	static HashMap<Long, Long> memo = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());
		
		System.out.println(fibo(n));
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