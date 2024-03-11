import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(n)]

for i in range(n): # 거쳐가는 노드 0~n번 노드까지 확인
    for a in range(n):
        for b in range(n):
            if arr[a][b] > arr[a][i] + arr[i][b]:
                arr[a][b] = arr[a][i]+arr[i][b]


for _ in range(m):
    start, end, time = map(int, input().split())
    if arr[start-1][end-1] <= time:
        print("Enjoy other party")
    else:
        print("Stay here")