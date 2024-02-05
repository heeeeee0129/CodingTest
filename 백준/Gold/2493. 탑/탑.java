import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(in.readLine());
		Stack<Pair> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(in.readLine());

		for(int i = 1; i<=T; i++) {
			Pair pair = new Pair(i, Integer.parseInt(st.nextToken()));
			
			if(stack.isEmpty()) {
				sb.append("0 ");
				
			}else {
				while(true) {
				if(stack.peek().height > pair.height) {
					sb.append(stack.peek().index + " ");
					break;
				}
				else {
					stack.pop();
					if(stack.isEmpty()) {
						sb.append("0 ");
						break;
					}
				}
				}
			}
			
			stack.add(pair);

		}

		System.out.println(sb);
	}

}

class Pair {
	int index, height;
	public Pair(int index, int height) {
		super();
		this.index = index;
		this.height = height;
	}

}