import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	static int t;
	static int min_cha = Integer.MAX_VALUE;
	static int[][] materials;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("1204_input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		t = Integer.parseInt(in.readLine());
		materials = new int[t][2];
		for(int test_case = 0; test_case<t; test_case++) {
			st = new StringTokenizer(in.readLine());
			materials[test_case][0] = Integer.parseInt(st.nextToken());
			materials[test_case][1] = Integer.parseInt(st.nextToken());
		}
		
		generateSubSet();
		sb.append(min_cha);
		System.out.println(sb);
	}
	
	private static void generateSubSet() {
		for(int flag = 1; flag < (1<<t); flag++) {
			int sour_sum = 1;
			int bitter_sum = 0;
			for(int i = 0; i<t; i++) {
				if((flag & (1<<i)) != 0){
					sour_sum *= materials[i][0];
					bitter_sum += materials[i][1];
				}
			}
			int cha = Math.abs(sour_sum-bitter_sum);
			if(min_cha > cha) min_cha = cha;
		}
	}
}