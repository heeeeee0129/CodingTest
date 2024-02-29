import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	
	static int n;
	static int[][] arr;
	static int min_len = Integer.MAX_VALUE;
	static boolean[] isSelected;
	static int[] path;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.parseInt(in.readLine());
		arr = new int[n][n];
		isSelected = new boolean[n];
		path = new int[n];
		
		StringTokenizer st;
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		path[0] = 0;
		isSelected[0] = true;
		perm(1);
		
		
		System.out.println(min_len);
		
	}
	
	public static void tsp(int x, int start_x) {
		

	}
	
	public static void perm(int cnt) {
		if(cnt == n) {
			int sum = arr[path[n-1]][path[0]];
			if(sum == 0)return;
			for(int i = 0; i<n-1; i++) {
				if(arr[path[i]][path[i+1]] == 0)return;
				sum += arr[path[i]][path[i+1]];
			}
			
			min_len = Math.min(sum, min_len);
			return;
		}
		
		for(int i = 1; i<n; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			path[cnt] = i;
			perm(cnt+1);
			isSelected[i] = false;
		}
		
		
	}
	
	public static class Node implements Comparable<Node>{

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}