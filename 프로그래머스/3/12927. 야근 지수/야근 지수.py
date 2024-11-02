import heapq

def solution(n, works):
    answer = 0
    
    max_heap = [-x for x in works]
    heapq.heapify(max_heap)
    
    for _ in range(n):
        el = heapq.heappop(max_heap)
        if el == 0:
            break
        heapq.heappush(max_heap, el + 1)
    
    for w in max_heap:
        answer += w * w
    
    return answer
