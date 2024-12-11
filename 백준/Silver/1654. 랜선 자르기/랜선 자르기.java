import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int N;
    static long[] arr;
    static long answer = -1;
    
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        for(int i = 0; i<K; i++){
            arr[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);

        long left = 1;
        long right = arr[K-1];
        long mid = -1;
        while(left <= right) {
            mid = (left+right)/2;
            int count = 0;
            for(int i = K-1; i >= 0; i--){
                count += arr[i] / mid;
                if(count > N){
                    break;
                }
            }
            if(count >= N){
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
        
    }
}