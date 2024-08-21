import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		int total = (1<<10)-1;
		
		for(int i = 1; i<=testcase; i++) {
			int N = Integer.parseInt(br.readLine());
			int visited = 0;
			int x = 1;
			while(true) {
				int temp = N * x;
				while(temp>0) {
					int number = temp % 10;
					temp /= 10;
					visited = visited | (1 << number);
					
				}
				if(visited == total) {
					System.out.println("#"+i + " " + (N*x));
					break;
				}
                x++;
			}
			
			
		}
	}
}