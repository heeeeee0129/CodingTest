import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i<r; i++) { /// 회전수 카운트
			for(int t = 0; t<Math.min(m, n)/2; t++) {//사각형 바퀴
				
				int temp = arr[t][t];
				for(int a = t; a<m-1-t; a++) {
					arr[t][a] = arr[t][a+1];
				}
				for(int a = t; a<n-1-t; a++) {
					arr[a][m-1-t] = arr[a+1][m-1-t];
				}
				for(int a = m-1-t; a>t; a--) {
					arr[n-1-t][a] = arr[n-1-t][a-1];
				}
				for(int a = n-1-t; a>t+1; a--) {
					arr[a][t] = arr[a-1][t];
				}
				arr[t+1][t] = temp;				
			}
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		
	
		System.out.println(sb);
	}
}