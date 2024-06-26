import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i<=input; i++) {
			q.offer(i);
		}
		while(q.size() != 1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
		
	}
}