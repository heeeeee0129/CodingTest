import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int k;
    public static int[] costs = new int[100001];
    public static Deque<Integer> queue = new ArrayDeque<>();
    public static int result;
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        Arrays.fill(costs, -1);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(n>=k){
            result = n - k;
        }else{
            queue.add(n);
            costs[n] = 0;
            while(!(queue.isEmpty())){
                int x = queue.poll();
                if(x == k){
                    result = costs[x];
                    break;
                }
                if(2*x < 100001 && costs[2*x] == -1){
                    costs[2*x] = costs[x];
                    queue.addFirst(2*x);
                }
                if(x > 0 && costs[x - 1] == -1){
                    costs[x-1] = costs[x]+1;
                    queue.addLast(x-1);
                }
                if(x < 100000 && costs[x+1] == -1){
                    costs[x+1] = costs[x]+1;
                    queue.addLast(x+1);
                }
            }
        }
        System.out.print(result);

    }
}