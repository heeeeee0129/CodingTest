import java.io.*;
import java.util.*;


public class Main {
    public static int[][] wheel = new int[4][8];
    public static int[] index = new int[4]; 
    public static int k;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i<4; i++){
            String input = in.readLine();
            for(int j = 0; j<8; j++){
                wheel[i][j] = input.charAt(j)-'0';
            }
        }

        k = Integer.parseInt(in.readLine());
        StringTokenizer st;
        for(int i = 0; i<k; i++){
            st = new StringTokenizer(in.readLine());
            int wheel_num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            rotate(wheel_num-1, dir, -1, 1);
            rotate(wheel_num-1, dir, 1, 0);
        }
        int sum = 0;
        for(int i = 0; i<4; i++){
            sum += wheel[i][index[i]]*Math.pow(2,i);
        }
        System.out.print(sum);
    }

    public static void rotate(int num, int dir, int x, int start){
        int idx = index[num];
        if(x == -1 && 
        num > 0 && 
        wheel[num][(idx+6)%8] != wheel[num-1][(index[num-1]+2)%8]){
            rotate(num-1, -dir, x, 0);
        }

        if( x == 1 &&
        num < 3 &&
        wheel[num][(idx+2)%8] != wheel[num+1][(index[num+1]+6)%8]) {
            rotate(num+1, -dir, x, 0);
        }

        if(start == 0){
            index[num] = (index[num]-dir+8)%8;
        }
    }

}