import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int minimum;
    public static int maximum;
    public static int[] nums;
    public static int[] op;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());
        minimum = Integer.MAX_VALUE;
        maximum = -Integer.MAX_VALUE;
        nums = new int[N];
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        op = new int[4];
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, nums[0], op[0], op[1], op[2], op[3]);

        System.out.println(maximum);
        System.out.println(minimum);
    }
    static void dfs(int n,int cur, int plus, int minus, int power, int divide){
            if(n == N){
                maximum = maximum < cur ? cur : maximum;
                minimum = minimum > cur ? cur : minimum;
                return;
            }
            if(plus>0){
                dfs(n+1, cur+nums[n], plus-1, minus, power, divide);
            }
            if(minus > 0){
                dfs(n+1, cur-nums[n], plus, minus-1, power, divide);
            }
            if(power > 0){
                dfs(n+1, cur*nums[n], plus, minus, power-1, divide);
            }
            if(divide > 0){
                dfs(n+1, cur/nums[n], plus, minus, power, divide-1);
            }
        }

}
