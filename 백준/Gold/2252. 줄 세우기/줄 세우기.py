import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
arr = [[] for _ in range(n+1)]
count = [0]*(n+1)
for _ in range(m):
    x, y = map(int, input().split())
    arr[x].append(y)
    count[y] += 1
    
queue = deque([])

for i in range(1, n+1):
    if count[i] == 0:
        queue.append(i)
while queue:
    node = queue.popleft()
    if count[node] == 0:
        print(node, end = ' ')
        count[node] = -1

    for to in arr[node]:
        count[to] -= 1
        if count[to] == 0:
            queue.append(to)