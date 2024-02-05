import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new ArrayDeque<>();
		Deque<Integer> res = new ArrayDeque<>();
		for(int i = 1; i<=n; i++) {
			dq.add(i);
		}
		int index = 0;
		while(dq.size()>1) {
			int temp = dq.pollFirst();
			if(!((index+1)%k==0)){
				dq.add(temp);
			}else {
				res.add(temp);
			}
			index = (index+1)%k;
		}
		res.add(dq.poll());
		sb.append("<");
		while(!(res.isEmpty())) {
			sb.append(res.pollFirst());
			if(!(res.isEmpty())) {
				sb.append(", ");
			}
		}
		sb.append(">");

		System.out.println(sb);
	}
}