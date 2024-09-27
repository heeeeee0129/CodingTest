import heapq
import sys

def solution(n, edge):
    answer = 0
    queue = []
    graph = [[] for _ in range(n)]
    distance = [sys.maxsize] * n
    heapq.heappush(queue, [0, 0])
    distance[0] = 0
    
    for e in edge:
        start, end = e
        graph[start-1].append(end-1)
        graph[end-1].append(start-1)
    
    while queue:
        cost, cur = heapq.heappop(queue)
        for next in graph[cur]:
            if cost+1 < distance[next]:
                distance[next] = cost+1
                heapq.heappush(queue, [cost+1, next])
                
    distance.sort()
    return distance.count(distance[-1])