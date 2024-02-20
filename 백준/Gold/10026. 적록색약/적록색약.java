import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	static int[][] dxdy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int n;
	static char[][] arr;
	static int count = 0;
	static int special_count = 0;
	static char[][] arr2;

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(in.readLine());
		arr = new char[n][n];
		arr2 = new char[n][n];
		for(int i = 0; i<n; i++) {
			String s = in.readLine();
			for(int j = 0; j<n; j++) {
				char c = s.charAt(j);
				arr[i][j] = c;
				if(c == 'R') {
					arr2[i][j] = 'G';
				}else {
					arr2[i][j] = c;
				}
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j] != 'X') {
					dfs(i, j, arr[i][j], arr);
					count++;
				}
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr2[i][j] != 'X') {
					dfs(i, j, arr2[i][j], arr2);
					special_count++;
				}
			}
		}
		
		
		sb.append(count +" " + (special_count));

		System.out.println(sb);
	}
	
	
	
	static void dfs(int x, int y, char current_color, char[][] array) {
		for(int i = 0; i<4; i++) {
			int curx = x + dxdy[i][0];
			int cury = y + dxdy[i][1];
			if(curx >= 0 && curx<n && cury>=0 && cury <n && array[curx][cury] == current_color) {
				char temp = array[curx][cury];
				array[curx][cury] = 'X';
				dfs(curx, cury, temp, array);
			}
		}
	}
}