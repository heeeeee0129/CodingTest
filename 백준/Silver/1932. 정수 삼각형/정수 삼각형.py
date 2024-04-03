import sys
input = sys.stdin.readline

n = int(input())

arr = [list(map(int, input().rstrip().split())) for _ in range(n)]


for i in range(1, n):
    for idx, value in enumerate(arr[i]):
        if idx == 0:
            arr[i][idx] += arr[i-1][0]
        elif idx == i:
            arr[i][idx] += arr[i-1][i-1]
        else:
            arr[i][idx] += max(arr[i-1][idx-1], arr[i-1][idx])
        

print(max(arr[n-1]))