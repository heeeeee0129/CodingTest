import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("1204_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		
		numbers = new int[N];
		isSelected = new boolean[N+1];
		permutation(0);
		

		System.out.println(sb);

	}

	private static void permutation(int cnt) {
		if(cnt == M) {
			for(int i = 0; i<M; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			numbers[cnt] = i+1;
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	
	
	
}