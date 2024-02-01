import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	static int count = 0;

	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("1204_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int total = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
		char[] dna = in.readLine().toCharArray();
		st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), g = Integer.parseInt(st.nextToken()), t = Integer.parseInt(st.nextToken());
		HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
			put('A', a);
			put('C', c);
			put('G', g);
			put('T', t);
		}};
		
		for(int i = 0; i<p; i++) {
			int temp = map.get(dna[i]);
			map.put(dna[i], temp-1);
		}
		if(isValid(map)) count++;
		for(int start = 0, end = p; end < total; start++, end++) {
			int temp = map.get(dna[start]);
			map.put(dna[start], temp+1);
			int temp2 = map.get(dna[end]);
			map.put(dna[end], temp2-1);
			if(isValid(map)) count++;
		}
		sb.append(count);

		System.out.println(sb);
	}
	
	
	static boolean isValid(HashMap<Character,Integer> map) {
		
		for(Entry<Character, Integer> e : map.entrySet()) {
			if(e.getValue() > 0) return false;
		}
		return true;
	}
	
	
}