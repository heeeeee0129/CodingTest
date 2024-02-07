import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	static int[][] arr;
	static int row; // n
	static int col; // m

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		
		for(int i = 0; i<row; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(in.readLine());
		for(int a = 0; a<r; a++) {
			int type = Integer.parseInt(st.nextToken());
			switch(type) {
			case 1:
				int[][] temp = new int[row][col];
				for(int i = 0; i<row; i++) {
					for(int j = 0; j<col; j++) {
						temp[i][j] = arr[row-i-1][j];
					}
				}
				arr = temp;
				break;
			case 2:
				temp = new int[row][col];
				for(int i = 0; i<row; i++) {
					for(int j = 0; j<col; j++) {
						temp[i][j] = arr[i][col-1-j];
					}
				}
				arr = temp;
				break;
			case 3:
				temp = new int[col][row];
				
				for(int i = 0; i<col; i++) {
					for(int j = 0; j<row; j++) {
						temp[i][j] = arr[row-j-1][i];
					}
				}
				int te = col;
				col = row;
				row = te;
				arr = temp;
				break;
			case 4:
				temp = new int[col][row];
				
				for(int i = 0; i<col; i++) {
					for(int j = 0; j<row; j++) {
						temp[i][j] = arr[j][col-i-1];
					}
				}
				te = col;
				col = row;
				row = te;
				arr = temp;
				break;
			case 5:
				
				temp = new int[row][col];
				for(int i = 0; i<row/2; i++) { // 1
					for(int j = 0; j<col/2; j++) {
						temp[i][j] = arr[i+row/2][j];
					}
				}
				for(int i = row/2; i<row; i++) { // 4
					for(int j = 0; j<col/2; j++)	{
						temp[i][j] = arr[i][j+col/2];
					}
				}
				for(int i = row/2; i<row; i++) { // 3
					for(int j = col/2; j<col; j++) {
						temp[i][j] = arr[i-row/2][j];
					}
				}
				for(int i = 0; i<row/2; i++) {
					for(int j = col/2; j<col; j++) {
						temp[i][j] = arr[i][j-col/2];
					}
				}
				arr = temp;
				break;
			case 6:
				
				temp = new int[row][col];
				for(int i = 0; i<row/2; i++) { // 1
					for(int j = 0; j<col/2; j++) {
						temp[i][j] = arr[i][j+col/2];
					}
				}
				for(int i = row/2; i<row; i++) { // 4
					for(int j = 0; j<col/2; j++)	{
						temp[i][j] = arr[i-row/2][j];
					}
				}
				for(int i = row/2; i<row; i++) { // 3
					for(int j = col/2; j<col; j++) {
						temp[i][j] = arr[i][j-col/2];
					}
				}
				for(int i = 0; i<row/2; i++) {
					for(int j = col/2; j<col; j++) {
						temp[i][j] = arr[i+row/2][j];
					}
				}
				arr=temp;
				break;
			default:
				break;
			}
		}

		for(int[] a :arr) {
			for(int i:a) {
				sb.append(i + " " );		
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}