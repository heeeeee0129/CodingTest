t = int(input())

dx = [1, -1, 0, 0] # 하 상 우 좌
dy = [0, 0, 1, -1]


def look_direction(x, y):
    global n, arr
    possible = []
    for d in range(4):
        count = 1
        curx, cury = x + dx[d], y+dy[d]
        while 0 <= curx <= n-1 and 0 <= cury <= n-1:
            if arr[curx][cury]:
                break
            
            if curx == 0 or curx == n-1 or cury == 0 or cury == n-1:
                possible.append((d, count))
            curx += dx[d]
            cury += dy[d]
            count+=1
    return possible # 각 코어 별 possible 배열 확인

# 탐색 순서를 순열로 확인
def look_core(cnt, sum_len, count):
    global max_core_count, min_length, core_count
    if cnt == core_count:
        if max_core_count < count:
            max_core_count = count
            min_length = sum_len
        elif max_core_count == count:
            min_length = min(min_length, sum_len)
        return
    x, y = core[cnt]
    possible = look_direction(x, y)
    if possible:
        for d, c in possible:
            curx, cury = x+dx[d], y+dy[d]
            while 0 <= curx <= n-1 and 0 <= cury <= n-1:
                arr[curx][cury] = 1
                curx += dx[d]
                cury += dy[d]
            look_core(cnt+1, sum_len+c, count+1)
            curx, cury = x+dx[d], y+dy[d]
            while 0 <= curx <= n-1 and 0 <= cury <= n-1:
                arr[curx][cury] = 0
                curx += dx[d]
                cury += dy[d]
    
    look_core(cnt+1, sum_len, count)


for test_case in range(1, t+1):
    n = int(input())
    arr = [[] for _ in range(n)]
    min_length = float('inf')
    max_core_count = 0
    core_count = 0
    core = []
    for i in range(n):
        row = list(map(int, input().split()))
        arr[i] = row
        for j in range(1, n-1):
            if row[j] == 1 and i != 0 and i != n-1:
                core.append((i,j)) # 입력 받고 코어 정보 저장
                core_count+=1
    look_core(0,0,0)

    print(f"#{test_case} {min_length}")