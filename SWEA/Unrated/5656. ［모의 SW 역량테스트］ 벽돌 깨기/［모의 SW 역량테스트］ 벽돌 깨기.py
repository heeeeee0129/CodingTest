t = int(input())

dxdy = [[-1, 0], [1, 0], [0, -1],[ 0, 1]]

def bomb(y, x, value, brick_map):
    global H, W
    brick_map[y][x] = 0
    for i in range(1, value):
        for d in range(4):
            curx = x + (i * dxdy[d][0])
            cury = y + (i * dxdy[d][1])
            if 0 <= curx < W and 0 <= cury < H:
                if brick_map[cury][curx] > 1:
                    bomb(cury, curx, brick_map[cury][curx], brick_map)
                brick_map[cury][curx] = 0
                

def brick_down(brick_map):
    global W, H
    new_map = [[0] * W for _ in range(H)]
    for i in range(W):
        idx = H-1
        for j in range(H-1, -1, -1):
            if brick_map[j][i]:
                new_map[idx][i] = brick_map[j][i]
                idx -= 1
    return new_map

def play(n, brick_map):
    global N, max_brick, W, test_case
    if n == N:
        max_brick = min(max_brick, sum(element >= 1 for row in brick_map for element in row))
        return

    for i in range(W):
        temp_map = [row[:] for row in brick_map]
        for j in range(H):
            if temp_map[j][i] > 0:
                bomb(j, i, temp_map[j][i], temp_map)
                temp_map = brick_down(temp_map)
                if sum(element >= 1 for row in temp_map for element in row) == 0:
                    max_brick = 0
                    return
                play(n+1, temp_map)
                break
            


for test_case in range(1, t+1):
    N, W, H = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(H)]
    max_brick = float('inf')
    play(0, arr)

    print(f"#{test_case} {max_brick}")
