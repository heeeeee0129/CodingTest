import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(in.readLine());
        for(int t = 0; t<test_case; t++ ){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] cow = new int[N];

            st = new StringTokenizer(in.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(in.readLine());
            for(int i = 0; i<N; i++){
                cow[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cow);

            int minValue = Integer.MAX_VALUE;
            int minCount = 0;

            st = new StringTokenizer(in.readLine());
            for(int i = 0; i<M; i++ ){
                int horse = Integer.parseInt(st.nextToken());
                int start = 0;
                int end = N-1;
                
                while(start <= end){
                    int mid = (start+end)/2;
                   	int dist = Math.abs(cow[mid] - horse);

                    if (dist < minValue) {
                        minValue = dist;
                        minCount = 1;
                    } else if (dist == minValue) {
                        minCount++;
                    }

                    if (cow[mid] < horse) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            int dx = Math.abs(c1 - c2);
            bw.write("#" + (t+1) + " " + (dx+minValue) + " "+minCount + "\n");

        }
       
        bw.flush();
        bw.close();


    }
}