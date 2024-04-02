import heapq
import sys
input = sys.stdin.readline


N, M, X = map(int, input().split())
arr1 = [[] for _ in range(N)]
arr2 = [[] for _ in range(N)]
for _ in range(M):
    start, end, cost = map(int, input().split())
    arr1[start-1].append([end-1, cost]) # 갈 때
    arr2[end-1].append([start-1, cost]) # 올 때
queue = []
dist = [sys.maxsize for _ in range(N)]
dist[X-1] = 0
heapq.heappush(queue, [0, X-1])
while queue:
    cost, node = heapq.heappop(queue)
    if cost > dist[node]:
        continue
    for next_node, c in arr1[node]:
        if cost+c < dist[next_node]:
            dist[next_node] = cost+c
            heapq.heappush(queue, [cost+c, next_node])

dist2 = [sys.maxsize for _ in range(N)]
dist2[X-1] = 0
heapq.heappush(queue, [0, X-1])
while queue:
    cost, node = heapq.heappop(queue)
    if cost > dist2[node]:
        continue
    for next_node, c in arr2[node]:
        if cost + c < dist2[next_node]:
            dist2[next_node] = cost + c
            heapq.heappush(queue, [cost+c, next_node])

print(max(dist[i]+dist2[i] for i in range(N)))