class Solution {
    public int solution(int n) {
        int answer = 0;
        String n_to_bin = Integer.toBinaryString(n);
        int n_count = 0;
        for(int i = 0; i<n_to_bin.length(); i++){
            if(n_to_bin.charAt(i)== '1'){
                n_count++;
            }
        }        
        while(true){
            n++;
            String num_to_bin = Integer.toBinaryString(n);
            int num_count = 0;
            for(int i = 0; i<num_to_bin.length(); i++){
                if(num_to_bin.charAt(i) == '1'){
                    num_count++;
                }
            }
            if(num_count == n_count){
                answer = n;
                break;
            }
            
        }
        return answer;
    }
}