import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start_node = Integer.parseInt(in.readLine());
		ArrayList<ArrayList<int[]>> arr = new ArrayList<ArrayList<int[]>>();
		for(int i = 0; i<=v; i++) {
			arr.add(new ArrayList<int[]>());
		}
		for(int i = 0; i<e; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr.get(start).add(new int[] {end, weight});
		}
		int[] costs = new int[v+1];
		
		for(int i = 0; i<=v; i++) {
			costs[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1]-b[1]);
		costs[start_node] = 0;
		q.add(new int[] {start_node, 0});
		
		while(!(q.isEmpty())) {
			int[] cur_node = q.poll();
			if (cur_node[1] > costs[cur_node[0]])continue;
			
			for(int[] next_node : arr.get(cur_node[0])) {
				int cur_sum = costs[cur_node[0]] + next_node[1];
				if(costs[next_node[0]] > cur_sum) {
					costs[next_node[0]] = cur_sum;
					q.add(new int[] {next_node[0], cur_sum});
				}
				
			}
		}
		for(int i = 1; i<=v; i++) {
			if(costs[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}else {
				sb.append(costs[i]+"\n");
			}
		}

		System.out.println(sb);
	}
}