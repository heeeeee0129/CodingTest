import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>((i1,i2)->{
			int a1 = Math.abs(i1);
			int a2 = Math.abs(i2);
			if(a1 == a2) {
				return i1-i2;
			}
			return a1-a2;
		});
		int T = Integer.parseInt(in.readLine());
		for(int i = 0; i<T; i++) {
			int num = Integer.parseInt(in.readLine());
			if(num == 0) {
				if(queue.isEmpty())sb.append("0\n");
				else sb.append(queue.poll()+ "\n");
			}else {
				queue.offer(num);
			}
		}

		System.out.println(sb);
	}
}