import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("1204_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int switch_num = Integer.parseInt(in.readLine());
		int[] switch_arr = new int[switch_num];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i<switch_num; i++) {
			switch_arr[i] = Integer.parseInt(st.nextToken());
		}

		int t = Integer.parseInt(in.readLine());
		for(int i = 0; i<t; i++) {
			st = new StringTokenizer(in.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			if(gender == 1) { //남학생이라면, 배수 번호의 스위치를 토글
				for(int k = 0; k<switch_num; k++) {
					if((k+1)%count == 0) {
						switch_arr[k] = (switch_arr[k] == 1) ? 0 : 1;
					}
				}
			}else { //여학생이라면, 좌우로 같을 경우 최대한으로 스위치를 토글
				switch_arr[count-1] = (switch_arr[count-1] == 1) ? 0: 1;
				for(int k=1; k<switch_num; k++) {
					if(count-1-k <0 || count-1+k>=switch_num) break;
					if(switch_arr[count-1-k] == switch_arr[count-1+k]) {
						switch_arr[count-1-k] = (switch_arr[count-1-k] == 1) ? 0 : 1;
						switch_arr[count-1+k] = (switch_arr[count-1+k] == 1) ? 0 : 1;
					}else {
						break;
					}
				}


			}
			
		}
		for(int i = 0; i<switch_num; i++) {
			System.out.print(switch_arr[i]+" ");
			if((i+1)%20 == 0)System.out.println();
		}
		


	}
}