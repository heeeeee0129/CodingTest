from collections import defaultdict


def solution(topping):
    answer = 0
    young = defaultdict(int)
    old = defaultdict(int)
    for top in topping:
        old[top] += 1
    old_len = len(old)
    for top in topping:
        old[top] -= 1
        if old[top] == 0: old_len -= 1
        young[top] += 1
        if old_len == len(young): answer+=1
    
    return answer