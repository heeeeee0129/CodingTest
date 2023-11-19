from itertools import permutations 

def solution(k, dungeons):
    
    answer = -1
    for iter in list(permutations(dungeons)):
        remain_k = k
        count = 0
        for a, b in iter:
            if remain_k >= a:
                remain_k -= b
                count += 1
            else:
                break
        answer = max(answer, count)
    return answer