import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=testcase ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int mask = (1<<n)-1;
			if((m & mask) == mask) {
				System.out.println("#"+t + " ON");
			}else {
				System.out.println("#"+t+" OFF");
			}
			
		}

	}

}