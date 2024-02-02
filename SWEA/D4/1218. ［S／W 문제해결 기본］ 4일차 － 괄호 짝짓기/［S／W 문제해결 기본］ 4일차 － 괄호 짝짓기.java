import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
	//'()', '[]', '{}', '<>'
	static HashMap<Character, Integer> open = new HashMap<Character, Integer>(){{
		put('(',1);
		put('[', 2);
		put('{', 3);
		put('<', 4);
	}};
	static HashMap<Character, Integer> close = new HashMap<Character, Integer>(){{
		put(')',1);
		put(']', 2);
		put('}', 3);
		put('>', 4);
	}};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++	) {
			int valid = 1;
			int num = Integer.parseInt(br.readLine());
			char[] strArr = br.readLine().toCharArray();
			Stack<Integer> stack = new Stack<>();
			for(char c : strArr) {
				if(open.containsKey(c)) {
					stack.add(open.get(c));
				}else {
					int pop = stack.pop();
					if(!(pop == close.get(c))) {
						valid=0;
						break;
					}
				}
			}
			System.out.println("#"+t+" "+valid);
	
		}
	}
}