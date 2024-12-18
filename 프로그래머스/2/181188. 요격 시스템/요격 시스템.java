import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (e1, e2) -> {
            int ans1 = Integer.compare(e1[1], e2[1]);
            if(ans1 == 0){
                return Integer.compare(e1[0], e2[0]);
            }
            return ans1;
        });
        
        int min_end = -1;
        for(int i = 0; i<targets.length; i++){
            int[] cur = targets[i];
            
            if(cur[0] >= min_end){
                answer++; min_end = cur[1];
            }
            
        }
    
        
        return answer;
    }
   
}