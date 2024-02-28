import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dxdy = {{0, 1}, {1, 0}, {1, 1}	};
	static int[][] arr;
	static int n;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		StringTokenizer st;
		arr = new int[n][n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0,1);

		System.out.println(count);
	}
	
	
	public static void dfs(int x1, int y1, int x2, int y2) {
		if(x2 == n-1 && y2 == n-1) {
			count++;
			return;
		}
		if(x1 == x2) { //가로
			if(y2+1 < n && arr[x2][y2+1] == 0) {
				dfs(x2, y2, x2, y2+1);
			}
			if(y2+1 <n && x2+1<n && arr[x2+1][y2+1] == 0 && arr[x2][y2+1] == 0 && arr[x2+1][y2] == 0) {
				dfs(x2, y2, x2+1, y2+1);
			}
		}else if(y1 == y2) {
			//세로
			if( x2+1<n && arr[x2+1][y2] == 0) {
				dfs(x2, y2, x2+1, y2);
			}
			if(y2+1 <n && x2+1<n&& arr[x2+1][y2+1] == 0&& arr[x2][y2+1] == 0 && arr[x2+1][y2] == 0) {
				dfs(x2, y2, x2+1, y2+1);
			}
		}else {
			//대각선
			if(y2+1 <n && arr[x2][y2+1] == 0) {
				dfs(x2, y2, x2, y2+1);
			}
			if(y2+1 <n && x2+1<n && arr[x2+1][y2+1] == 0&& arr[x2][y2+1] == 0 && arr[x2+1][y2] == 0) {
				dfs(x2, y2, x2+1, y2+1);
			}
			if( x2+1<n && arr[x2+1][y2] == 0) {
				dfs(x2, y2, x2+1, y2);
			}
		}
		
	
		
	}
	
}