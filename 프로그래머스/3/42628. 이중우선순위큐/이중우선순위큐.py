import heapq

def solution(operations):
    min_heap = []
    max_heap = []
    
    for operation in operations:
        op, value = operation.split()
        
        if op == "D" and min_heap:
            if value == "1":
                min_heap.remove(-heapq.heappop(max_heap))

            elif value == "-1":
                max_heap.remove(-heapq.heappop(min_heap))
                    
        elif op == "I":
            heapq.heappush(min_heap, int(value))
            heapq.heappush(max_heap, -int(value))
            
    if not min_heap or not max_heap:
        return [0, 0]
    
    return [ -heapq.heappop(max_heap),heapq.heappop(min_heap)]