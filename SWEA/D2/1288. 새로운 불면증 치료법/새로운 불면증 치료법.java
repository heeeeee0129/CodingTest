import java.util.*;
import java.io.*;


public class Solution  {
    static int n;
    static boolean[] count;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for(int test_case = 1; test_case <= t; test_case++){
            n = Integer.parseInt(in.readLine());
            int x = 1;
            int c = 10;
            count = new boolean[10];
            while(true){
                int temp = n * x;
                while(temp > 0) {
                    int number = temp % 10;
                    temp /= 10;
                    if(!count[number]){
                        c--;
                        count[number] = true;
                    }  
                    if(c == 0){
                        break;
                    }
                }
                if(c == 0){
                        System.out.println("#" + test_case + " " + (n*x));
                        break;
                    }
                x++;
            }
        }
    }
}