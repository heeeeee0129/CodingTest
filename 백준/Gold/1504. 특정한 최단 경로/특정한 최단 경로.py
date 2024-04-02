import heapq
import sys
input = sys.stdin.readline

def shortest(f):
    global arr, N
    queue = []
    dist = [sys.maxsize for _ in range(N+1)]
    dist[f] = 0
    heapq.heappush(queue, [0, f])
    while queue:
        cost, node = heapq.heappop(queue)
        if cost > dist[node]:
            continue
        for next_node, c in arr[node]:
            if cost + c < dist[next_node]:
                dist[next_node] = cost+c
                heapq.heappush(queue, [cost+c, next_node])

    return dist

N, E = map(int, input().split())
arr = [[] for _ in range(N+1)]
for _ in range(E):
    start, end, cost = map(int, input().split())
    arr[start].append([end, cost])
    arr[end].append([start, cost]) #양방향 그래프

first, second = map(int, input().split())

d_from_start = shortest(1)
d_from_first = shortest(first)
d_from_second = shortest(second)

answer = min(d_from_start[first] + d_from_first[second] + d_from_second[N], d_from_start[second]+d_from_second[first]+d_from_first[N])

print(answer) if answer < sys.maxsize else print(-1)