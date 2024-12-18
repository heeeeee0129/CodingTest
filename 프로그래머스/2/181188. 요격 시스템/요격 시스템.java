import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (e1, e2) -> {
            int ans1 = Integer.compare(e1[0], e2[0]);
            if(ans1 == 0){
                return Integer.compare(e1[1], e2[1]);
            }
            return ans1;
        });
        
        int min_end = -1;
        for(int i = 0; i<targets.length; i++){
            if(targets[i][0] >= min_end){
                answer++; min_end = targets[i][1];
            }else{
                min_end = Math.min(targets[i][1], min_end);
            }
            
        }
        return answer;
    }
   
}