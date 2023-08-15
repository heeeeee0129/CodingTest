import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    length = len(scoville)
    for i in range(0, length-1):
        first = heapq.heappop(scoville)
        if first >= K:
            return i
        second = heapq.heappop(scoville) * 2
        heapq.heappush(scoville, first+second)
        
    if heapq.heappop(scoville) >= K:
        return length-1
    
    return -1