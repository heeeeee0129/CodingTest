import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] numbers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("1204_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[m];
		cal(0, 1);


	}

	private static void cal(int cnt, int cur) {
		if(cnt == m) {
			for(int i: numbers) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = cur; i<=n; i++) {
			numbers[cnt] = i;
			cal(cnt+1, i+1);
		}
		
	}
}