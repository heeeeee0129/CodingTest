import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int[][] arr;
	static int turn;
	static int count;
	static int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		Queue<Pair> queue = new LinkedList<>();
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			queue.add(new Pair(0, 0));
			turn++;
			int c = 0;
			int[][] visited = new int[n][m];
			while(!(queue.isEmpty())) {
				Pair p = queue.poll();
				for(int i = 0; i<4; i++) {
					int curx = p.x + dxdy[i][0];
					int cury = p.y + dxdy[i][1];
					if(curx >=0 && curx<n&&cury>=0&&cury<m&&visited[curx][cury] == 0) {
						visited[curx][cury] = 1;
						if(arr[curx][cury]==0) {	
							queue.add(new Pair(curx, cury));
						}else {
							c++;
							arr[curx][cury] = 0;
						}
					}
				}
			}
			
			if(c == 0) {
				break;
			}else {
				count = c;
			}
			
		}
		sb.append((turn-1)+"\n"+count);
		

		System.out.println(sb);
	}
	
	
	
	
}


class Pair {
	int x;
	int y;
	
	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}