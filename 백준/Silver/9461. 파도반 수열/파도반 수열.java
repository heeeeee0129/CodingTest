import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		long[] arr = new long[101];
		for(int i = 0; i<101; i++) {
			if (i<3) {
				arr[i] = 1;
			}
			else {
				arr[i] = arr[i-2] + arr[i-3];
			}
		}
		for(int i = 0; i<t; i++) {
			int n = Integer.parseInt(in.readLine());
			System.out.println(arr[n-1]);
		}
	}
}