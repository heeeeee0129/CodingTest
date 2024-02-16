import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int n;
	static int m;
	static int[] selected;
	static int[] archer = new int[3];
	static int[][] dxdy = {{0, -1}, {-1, 0}, {0, 1}};
	static int d;
	static int cut_line;
	static int max_enemy = 0;
	

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m];
		d = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		sb.append(max_enemy);

		System.out.println(sb);
	}
	
	static public int[] bfs(int num, int[][] input) { //궁수의 열 번호를 넣으면 현재의 cut_line에 맞춰서 제거할 수 있는 적의 좌표를 리턴
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {cut_line, num, 0});
		int[][] visited = new int[cut_line+1][m];
		
		while(!(queue.isEmpty())) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			int count = temp[2];
			if(count == d) {
				break;
			}
			visited[x][y] = 1;
			for(int i = 0; i<3; i++) {
				int curx = temp[0] + dxdy[i][0];
				int cury = temp[1] + dxdy[i][1];
				if( cury<m && curx>=0 && cury >=0 && visited[curx][cury] == 0) {
					if(curx < cut_line && input[curx][cury] == 1) {
						return new int[] {curx, cury};
					}
					queue.add(new int[] {curx, cury, count+1});
				}
			}
		}
		return null; //해당하는 적이 없을 경우에는 null 리턴. 체크하기
		
	}
	
	
	static public void comb(int cnt, int start) {
		if(cnt == 3) {
			int[] archer = new int[3];
			int idx = 0;
			for(int i = 0; i<m; i++) {
				if(selected[i] == 1) {
					archer[idx++] = i;
				}
			}
			cut_line = n;
			int count_enemy = 0;
			int[][] copy = new int[arr.length][arr[0].length];
			for (int i = 0; i < arr.length; i++) {
			    copy[i] = Arrays.copyOf(arr[i], arr[i].length);
			}

			while(cut_line>0) {
				int[][] enemy = new int[3][2];
				for(int i = 0; i<3; i++) {
					enemy[i] = bfs(archer[i], copy);
				}
				for(int i = 0; i<3; i++) {
					if(enemy[i] != null && copy[enemy[i][0]][enemy[i][1]] == 1) {
						count_enemy += 1;
						copy[enemy[i][0]][enemy[i][1]] = 0;
					}
				}
				cut_line--;			
			}
			
			max_enemy = Math.max(max_enemy, count_enemy);
						
			return;
		}else {
			for(int i = start; i<m; i++) {
				selected[i] = 1;
				comb(cnt+1, i+1);
				selected[i] = 0;
			}
		}
		
	}
}