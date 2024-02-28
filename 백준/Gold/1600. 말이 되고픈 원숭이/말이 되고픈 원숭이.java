import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] monkey = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
	static int[][] horse = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}}; //len:8
	static int[][] arr;
	static boolean[][][] visited;
	static int k;
	static int h;
	static int w;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		visited = new boolean[h][w][k+1];
		for(int i = 0; i<h; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());	
	}
	
	
	public static int bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		visited[0][0][k] = true;
		queue.add(new Node(0, 0, k, 0));
		
		
		
		while(!(queue.isEmpty())) {
			
			Node cur = queue.poll();
			if(cur.x == h-1 && cur.y == w-1) return cur.count;
			
			if(cur.k_count > 0) { // 말 이동
				for(int d = 0; d <8; d++){
					int curx = cur.x + horse[d][0];
					int cury = cur.y + horse[d][1];
					
					if(curx < h && curx >= 0 && cury < w && cury >= 0 && arr[curx][cury] != 1) {
						if(visited[curx][cury][cur.k_count-1] == false) {
							visited[curx][cury][cur.k_count-1] = true;
							queue.add(new Node(curx, cury, cur.k_count-1, cur.count+1));
						}
					}
				}
			}
			for(int d = 0; d<4; d++) { // 원숭이 이동
				int curx = cur.x + monkey[d][0];
				int cury = cur.y + monkey[d][1];
				
				if(curx < h && curx >= 0 && cury < w && cury >= 0 && 
						arr[curx][cury] != 1 && 
						visited[curx][cury][cur.k_count] == false) {
					visited[curx][cury][cur.k_count] = true;
					queue.add(new Node(curx, cury, cur.k_count, cur.count+1));
				}
				
			}
			
		}
		return -1;
	
	}
	
	public static class Node{
		int x;
		int y;
		int k_count;
		int count;
		
		public Node(int x, int y, int k_count, int count) {
			super();
			this.x = x;
			this.y = y;
			this.k_count = k_count;
			this.count = count;
		}

		
	}
	
	
	
	
}