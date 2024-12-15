import java.util.*;
import java.io.*;


class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int low = 1;
        int high = 100000;
        int min_level = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high) / 2;
            boolean res = calcTime(diffs, times, limit, mid);
            
            if(res){
                high = mid - 1;
                if(mid < min_level) min_level = mid;
            }else{
                low = mid + 1;
            }
        }
        
        return min_level;
    }
    
    public boolean calcTime(int[] diffs, int[] times, long limit, int level){
        long time_sum = 0;
        for(int i = 0; i<diffs.length; i++){
            if(diffs[i] <= level){
                // 숙련도가 더 높으면 그냥 해당 소요시간
                time_sum += times[i];
            }else{
                time_sum += ((times[i] + times[i-1]) * (diffs[i] - level) + times[i]);
            }
            if(time_sum > limit) {
                break;
            }
        }
        
        if(time_sum > limit) return false;
        return true;
    }
}