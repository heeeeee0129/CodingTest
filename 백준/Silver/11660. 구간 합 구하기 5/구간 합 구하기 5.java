import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[n][n];
		int[][] sum_matrix = new int[n+1][n+1];

		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				sum_matrix[i+1][j+1] = sum_matrix[i+1][j] + matrix[i][j];
			}
		}
		
		for(int i = 1; i<n+1; i++) {
			for(int j = 1; j<n+1; j++) {
				sum_matrix[i][j] += sum_matrix[i-1][j];
			}
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			
			System.out.println(sum_matrix[end_x][end_y]-sum_matrix[start_x-1][end_y]-sum_matrix[end_x][start_y-1]+sum_matrix[start_x-1][start_y-1]);
		}
		
		
	}
}