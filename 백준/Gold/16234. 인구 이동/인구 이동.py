import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

n, l, r = map(int, input().split())
arr = [list(map(int, input().rstrip().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

answer = 0

while True:
    visited = [[False] * n for _ in range(n)]
    count = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                union_list = [(i, j)]
                sum_population = arr[i][j]
                visited[i][j] = True
                queue = deque([])
                queue.append([i, j])
                while queue:
                    x, y = queue.popleft()
                    for d in range(4):
                        curx = x + dx[d]
                        cury = y + dy[d]
                        if 0 <= curx < n and 0 <= cury < n and not visited[curx][cury]:
                            if l <= abs(arr[curx][cury]-arr[x][y]) <= r:
                                visited[curx][cury] = True
                                count += 1
                                queue.append([curx, cury])
                                union_list.append((curx, cury))
                                sum_population += arr[curx][cury]
                result = sum_population//len(union_list)
                for x, y in union_list:
                    arr[x][y] = result
    if count == 0:
        break
    answer += 1
    

print(answer)