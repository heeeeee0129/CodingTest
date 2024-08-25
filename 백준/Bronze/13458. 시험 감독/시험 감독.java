import java.util.*;
import java.io.*;


public class Main {
    public static int N;
    public static int[] arr; 
    public static int B;
    public static int C;

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // if(B < C){
        //     B = C;
        // }
        long total = 0;
        for(int i = 0; i<N; i++){
            if(arr[i] <= B){
                total += 1;
                continue;
            }else{
                arr[i] -= B;
                total += 1;
                if(arr[i] > 0){
                    total += arr[i]/C;
                    if(arr[i]%C != 0){
                        total+=1;
                    }
                }
            }
        }

        System.out.print(total);


    }
}