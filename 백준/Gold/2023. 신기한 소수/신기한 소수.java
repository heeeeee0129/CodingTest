import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	static int t;
	static int[] intArr;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("1204_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(in.readLine());
		intArr = new int[t];
		permutation(0);

		System.out.println(sb);
	}
	
	static void permutation(int cnt) {
		if(cnt == t) {
			//여기서 신기한 소수인지 판별하고, 신기한 소수일경우 출력
			int value = 0;
			for(int i = 0; i<t; i++) {
				value = value*10 + intArr[i];
				if(!isValid(value)) {
					return;
				}
			}			
			for (int i = 0; i < t; i++) {
                sb.append(intArr[i]);
            }
            sb.append("\n");
			return;
		}
		else {
			for(int i = 1; i<10; i++) {
				if(i >2 && i%2 == 0)continue;
				intArr[cnt]= i;
				permutation(cnt+1);
			}
		}
	}
	
	static boolean isValid(int num) {
		
		if(num == 1) return false;
		for(int i = 2; i<=Math.sqrt(num); i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
}