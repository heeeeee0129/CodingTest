import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int R;
	static int C;
	static int T;
	static int[][] arr;
	static int pos;
	static int[][] up = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //반시계방향
	static int[][] down = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; //시계방향
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == -1) {
					pos = i; ///공기 청정기 아래쪽 행 번호 저장
				}
			}
		}
		for(int k = 0; k<T; k++) {
			spread();
//			for(int i = 0; i<R; i++) {
//				for(int j = 0; j<C; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
			clean();
//			for(int i = 0; i<R; i++) {
//				for(int j = 0; j<C; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		int result = 0;
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(arr[i][j] >=0 ) {
					result += arr[i][j];
				}
			}
		}
		System.out.println(result);
		
	}
	
	static int[][] dxdy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	private static void spread() {
		int[][] temp = new int[R][C];
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				if(arr[i][j] > 0) {
					int minus_sum = 0;
					int dust = arr[i][j]/5;
					for(int d = 0; d<4; d++) {
						int curx = i + dxdy[d][0];
						int cury = j + dxdy[d][1];
						if(curx >= 0 && curx < R && cury >= 0 && cury < C && arr[curx][cury] != -1) {
							temp[curx][cury] += dust;
							minus_sum += dust;
						}
					}
					temp[i][j] -= minus_sum;
				}
			}
		}
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				arr[i][j] += temp[i][j];
			}
			
		}
		
	}
	
	//공기청정기 위치 :
	//위쪽 : arr[pos-1][0]
	//아래쪽 : arr[pos][0]
	
	private static void clean() {
		int idx = 0;
		int x = pos-1;
		int y = 0;
		while(true) {
			int next_x = x + up[idx][0];
			int next_y = y + up[idx][1];
			if(next_x == pos-1 && next_y == 0) {
				arr[x][y] = 0;
				break;
			}
			if(next_x < 0 || next_x >= R || next_y < 0 || next_y >= C || (next_x == pos && next_y == C-1)) {
				idx++;
			}else {
				arr[x][y] = arr[next_x][next_y];
				x = next_x;
				y = next_y;
			}
		}
		idx = 0;
		x = pos;
		y = 0;
		while(true) {
			int next_x = x + down[idx][0];
			int next_y = y + down[idx][1];
			if(next_x == pos && next_y == 0) {
				arr[x][y] = 0;
				break;
			}
			if(next_x < 0 || next_x >= R || next_y < 0 || next_y >= C || (next_x == pos-1 && next_y == C-1)) {
				idx++;
			}else {
				arr[x][y] = arr[next_x][next_y];
				x = next_x;
				y = next_y;
			}
		}
		arr[pos-1][0] = -1;
		arr[pos][0] = -1;
	}
	
	
}