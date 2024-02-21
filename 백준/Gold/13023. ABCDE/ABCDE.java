import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] visited;
	static List<Integer>[] list;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];
		for(int i = 0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		for(int i = 0; i<n; i++) {
			dfs(i, 1, new boolean[n]);
			if(answer == 1)break;
		}
		sb.append(answer);
		System.out.println(sb);
	}
	
	public static void dfs(int node, int count, boolean[] visited) {
		if (count == 5) {
			answer = 1;
			return;
		}
		visited[node] = true;
		for(int next: list[node]) {
			if(!visited[next])dfs(next, count+1, visited);
		}
		visited[node] = false;
	}
}