def solution(n, lost, reserve):    
    answer = 0
    dup = [x for x in lost if x in reserve]
    reserve = [x for x in reserve if x not in dup]
    lost = [x for x in lost if x not in dup]
    
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
