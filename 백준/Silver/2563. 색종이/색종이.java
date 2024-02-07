import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[100][100];
		int T;
		StringTokenizer st;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int i = 0; i<10; i++) {
				for(int j = 0; j<10; j++) {
					arr[x+i][y+j]+=1;
				}
			}
		}
		int count = 0;
		for(int i = 0; i<100; i++) {
			for(int j = 0; j<100; j++) {
				if(arr[i][j] != 0)count++;
			}
		}
		sb.append(count);

		System.out.println(sb);
	}
}