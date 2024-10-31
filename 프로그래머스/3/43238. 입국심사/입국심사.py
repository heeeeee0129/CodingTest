import sys 
def solution(n, times):
    answer = 0
    max_time = sys.maxsize
    min_time = 1
    
    while min_time <= max_time:
        time = (min_time + max_time) // 2
        count = 0
        
        for t in times:
            count += time // t
            if count >= n:
                max_time = time - 1
                answer = time
        if count < n:
            min_time = time + 1
            
    return answer
