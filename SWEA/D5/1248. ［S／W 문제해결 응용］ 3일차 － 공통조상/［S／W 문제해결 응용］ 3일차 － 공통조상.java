import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int v;
	static int e;
	static int child1;
	static int child2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		StringTokenizer st;
		for(int test_case = 1; test_case<=t; test_case++) {
			st = new StringTokenizer(in.readLine());
			HashSet<Integer> parents = new HashSet<>();
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			child1 = Integer.parseInt(st.nextToken());
			child2 = Integer.parseInt(st.nextToken());
			Node[] tree = new Node[v+1];
			for(int i = 0; i<=v; i++) {
				tree[i] = new Node();
			}

			st = new StringTokenizer(in.readLine());
			for(int i = 0; i<e; i++) {
				int prnt = Integer.parseInt(st.nextToken());
				int chld = Integer.parseInt(st.nextToken());
				tree[prnt].children.add(chld);
				tree[chld].parent = prnt;
			}
			// 트리 정보 입력은 완료
			
			int cur_node = child1;
			while(tree[cur_node].parent != 0){
				parents.add(tree[cur_node].parent);
				cur_node = tree[cur_node].parent;
			}
			
			cur_node = child2;
			int common = 0;
			while(tree[cur_node].parent != 0) {
				if(parents.contains(tree[cur_node].parent)) {
					common = tree[cur_node].parent;
					break;
				}
				cur_node = tree[cur_node].parent;
			}
			//공통조상은 common에 찾아둠
			queue.add(common);
			int count = 1;
			while(!(queue.isEmpty())) {
				int cur = queue.poll();
				for(int child: tree[cur].children) {
					count++;
					queue.add(child);
				}
			}
			System.out.println("#" + test_case + " " + common + " " + count);
			
			
		}

	}
	
	
	
	static public class Node {
		List<Integer> children;
		int parent;

		Node() {
			this.children = new ArrayList<>();
			this.parent = 0;
		}
	}
}