dxdy = [[-1, 0], [0, 1], [1, 0], [0, -1]] # 상 우 하 좌
block = [[2, 3, 1, 0], [1, 3, 0, 2], [3, 2, 0, 1], [2, 0, 3, 1], [2, 3, 0, 1]]

def play(cur_x, cur_y, direct):
    global max_count, arr, worm, block, n, dxdy
    start_x, start_y = cur_x, cur_y
    count = 0
    while True:
        cur_x += dxdy[direct][0]
        cur_y += dxdy[direct][1]
    
        if cur_x < 0 or cur_x >= n or cur_y < 0 or cur_y >= n: # 벽이라면
            count += 1
            direct = block[4][direct]
        else:
            if arr[cur_x][cur_y] == -1 or (start_x, start_y) == (cur_x, cur_y):
                return count
            elif 1 <= arr[cur_x][cur_y] <= 5: # 블록이라면
                count += 1
                direct = block[arr[cur_x][cur_y]-1][direct]
            elif 6 <= arr[cur_x][cur_y] <= 10: # 웜홀이라면
                cur_x, cur_y = worm[(cur_x, cur_y)]
            else:
                continue
    return count
            

arr = []

t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]
    worm = {}
    worm_temp = [0] * 5
    for row in range(n):
        for col in range(n):
            if 6 <= arr[row][col] <= 10:
                worm_num = arr[row][col]
                if worm_temp[worm_num-6]: # 두 번째 웜홀
                    worm[worm_temp[worm_num-6]] = (row, col)
                    worm[(row, col)] = worm_temp[worm_num-6]
                else: # 첫 번째 웜홀
                    worm_temp[worm_num-6] = (row, col)
    max_count = -1
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 0:
                for d in range(4):
                    max_count = max(max_count, play(i, j, d))

    print(f"#{test_case} {max_count}")
