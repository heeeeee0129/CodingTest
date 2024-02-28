import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	static int[][] arr = new int[30][30];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		
		
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			sb.append(cal(n, m)+ "\n");
		}

		System.out.println(sb);
	}
	
	public static int cal(int n, int m) {
		if(n == 0 || n == m) {
			arr[n][m] = 1;
			return 1;
		}
		if(arr[n][m] != 0){return arr[n][m];}
		int result = cal(n-1, m-1) + cal(n, m-1);
		arr[n][m] = result;
		return result;		
	}
}