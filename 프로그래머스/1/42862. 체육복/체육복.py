def solution(n, lost, reserve):    
    answer = 0
    lost = set(lost)
    reserve = set(reserve)
    dup = lost.intersection(reserve)
    lost -= dup
    reserve -= dup
    
    for i in range(1, n+1):
        if i in lost: 
            if i-1 in reserve:
                reserve.remove(i-1)
                answer+=1
            elif i+1 in reserve:
                reserve.remove(i+1)
                answer+=1
        else:
            answer+=1
                   
    
    return answer