import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader in = new BufferedReader(new java.io.InputStreamReader(System.in));
        
    	int t = Integer.parseInt(in.readLine());
    	for(int test_case = 1; test_case <= t; test_case++) {
    		
    		 	int n = Integer.parseInt(in.readLine());
    	        int m = Integer.parseInt(in.readLine());

    	        List<List<Integer>> arrIn = new ArrayList<>();
    	        List<List<Integer>> arrOut = new ArrayList<>();
    	        int[] countIn = new int[n + 1];
    	        int[] countOut = new int[n + 1];
    	        int answer = 0;

    	        for (int i = 0; i <= n; i++) {
    	            arrIn.add(new ArrayList<>());
    	            arrOut.add(new ArrayList<>());
    	        }

    	        for (int i = 0; i < m; i++) {
    	        	StringTokenizer st = new StringTokenizer(in.readLine());
    	        	
    	            int start = Integer.parseInt(st.nextToken());
    	            int end = Integer.parseInt(st.nextToken());
    	            arrOut.get(start).add(end);
    	            arrIn.get(end).add(start);
    	            countOut[start]++;
    	            countIn[end]++;
    	        }

    	        for (int i = 1; i <= n; i++) {
    	            int[] visited = new int[n + 1];
    	            visited[i] = 1;

    	            if (countIn[i] > 0) {
    	                Queue<Integer> queue = new LinkedList<>();
    	                queue.addAll(arrIn.get(i));
    	                while (!queue.isEmpty()) {
    	                    int node = queue.poll();
    	                    if (visited[node] != 1) {
    	                        visited[node] = 1;
    	                        if (countIn[node] > 0) {
    	                            queue.addAll(arrIn.get(node));
    	                        }
    	                    }
    	                }
    	            }

    	            if (countOut[i] > 0) {
    	                Queue<Integer> queue = new LinkedList<>();
    	                queue.addAll(arrOut.get(i));
    	                while (!queue.isEmpty()) {
    	                    int node = queue.poll();
    	                    if (visited[node] != 1) {
    	                        visited[node] = 1;
    	                        if (countOut[node] > 0) {
    	                            queue.addAll(arrOut.get(node));
    	                        }
    	                    }
    	                }
    	            }

    	            boolean allVisited = true;
    	            for (int e : Arrays.copyOfRange(visited, 1, visited.length)) {
    	                if (e != 1) {
    	                    allVisited = false;
    	                    break;
    	                }
    	            }
    	            if (allVisited) {
    	                answer++;
    	            }
    	        }
    	        System.out.println("#" + test_case + " " + answer);
    	}
    	
       
    }
}