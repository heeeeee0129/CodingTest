import java.util.*;
import java.io.*;


public class Main {

    public static int n;
    public static int k;
    public static int[] prev;
    public static int[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        prev = new int[100001];
        Queue<Integer> queue = new ArrayDeque();
        queue.add(n);
        visited[n] = 1;
        
        while(!(queue.isEmpty())){
            int cur = queue.poll();
            int cur_count = visited[cur];
            if(cur == k){
                System.out.println(visited[k]-1);
                ArrayList<Integer> route = new ArrayList<>();
                while(cur != n){
                    route.add(cur);
                    cur = prev[cur];
                }
                route.add(cur);
                for(int i = route.size()-1; i>=0; i--){
                    System.out.print(route.get(i) + " " );
                }
                break;
            }
            if(cur-1 >= 0 && visited[cur-1] == 0 ){
                visited[cur-1] = cur_count+1;
                prev[cur-1] = cur;
                queue.add(cur-1);
            }
            if(cur+1 <= 100000 && visited[cur+1] == 0 ){
                visited[cur+1] = cur_count+1;
                prev[cur+1] = cur;
                queue.add(cur+1);
            }
            if(2*cur <= 100000 && visited[2*cur] == 0 ){
                visited[2*cur] = cur_count+1;
                prev[2*cur] = cur;
                queue.add(2*cur);
            }
        }
    }
}