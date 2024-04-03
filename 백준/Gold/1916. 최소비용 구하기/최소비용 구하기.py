import sys
import heapq
input = sys.stdin.readline

n = int(input())
m = int(input())

arr = [[] for _ in range(n+1)]
answer = 0
for _ in range(m):
    start, end, cost = map(int, input().rstrip().split())
    arr[start].append([end, cost])
    

queue = []
s, goal = map(int, input().split())
heapq.heappush(queue, [0, s])
dist = [sys.maxsize] * (n+1)
dist[s] = 0

while queue:
    cost, node = heapq.heappop(queue)
    if node == goal:
        print(cost)
        break
    if dist[node] < cost:
        continue 
    for next_node, c in arr[node]:
        if dist[next_node] > cost+c:
            dist[next_node] = cost+c
            heapq.heappush(queue, [cost+c, next_node])