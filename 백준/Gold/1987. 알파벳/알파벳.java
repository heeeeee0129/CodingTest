import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited_alpha = new boolean[26];
	static boolean[][] visited;
	static int[][] dxdy = {{-1,0}, {1, 0}, {0, -1}, {0,1}};
	private static StringBuilder sb = new StringBuilder();
	static int max_count;
	static int[][] arr;
	static int r;
	static int c;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		visited = new boolean[r][c];
		for(int i = 0; i<r; i++) {
			String s = in.readLine();
			for(int j = 0; j<c; j++) {
				arr[i][j] = s.charAt(j)-'A';
			}
		}
		
		dfs(0,0,0);
		sb.append(max_count);

		System.out.println(sb);
	}
	
	static void dfs(int x, int y, int count) {
		visited_alpha[arr[x][y]] = true;
		visited[x][y] = true;
		max_count = Math.max(max_count, count+1);
		for(int i = 0; i<4; i++) {
			int curx = x + dxdy[i][0];
			int cury = y + dxdy[i][1];
			if(curx < r && cury < c && curx>=0 && cury >=0 && visited[curx][cury]==false && visited_alpha[arr[curx][cury]] ==false) {
				dfs(curx, cury, count+1);
			}
		}
		visited_alpha[arr[x][y]] = false;
        visited[x][y] = false;
	}
}