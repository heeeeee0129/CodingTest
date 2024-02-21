import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	static int l;
	static int c;
	static char[] arr;
	static int count_mo;
	static boolean[] selected;
	static char[] password;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(in.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[c];
		selected = new boolean[c];
		password = new char[l];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		perm(0, 0);
		
		System.out.println(sb);
	}
	
	public static void perm(int st, int cnt) {
		if(cnt == l) {
			if(count_mo >=1 && count_mo <=l-2) {
				for(int i = 0; i<l; i++) {
					sb.append(password[i]);
				}
				sb.append("\n");
			}
		}else {
			for(int i = st; i<c; i++) {
				if(selected[i]) continue;
				
				selected[i] = true;
				boolean isMo = false;
				if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
					isMo = true;
				}
				if(isMo)count_mo++;
				password[cnt] = arr[i];
				perm(i+1, cnt+1);
				if(isMo)count_mo--;
				selected[i] = false;
			}
		}
	}
}