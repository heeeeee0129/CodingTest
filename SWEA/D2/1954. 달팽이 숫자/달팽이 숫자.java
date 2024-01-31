import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static StringBuilder sb = new StringBuilder();
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(in.readLine());
		int[][] dydx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+"\n");
			n = Integer.parseInt(in.readLine());
			int curx = 0;
			int cury = 0;
			int count = 0;
			int d = 0;
			int[][] arr = new int[n][n];
			arr[curx][cury] = ++count;
			while(count<n*n) {
				curx += dydx[d][0];
				cury += dydx[d][1];
				if (isIn(curx, cury)==true && arr[curx][cury] == 0) {
					arr[curx][cury] = ++count;
				}else {
					curx-=dydx[d][0];
					cury -= dydx[d][1];
					d = (d+1)%4;
				}
			}
			
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static boolean isIn(int x, int y) {
		if(x>=0&& x<n&&y>=0&&y<n)return true;
		else return false;
	}
	
	
}