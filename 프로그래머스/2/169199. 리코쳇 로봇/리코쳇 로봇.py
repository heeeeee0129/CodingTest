import heapq

dxdy = [[1, 0], [-1, 0], [0, 1], [0, -1]]

def solution(board):
    answer = -1
    queue = []
    n, m = len(board), len(board[0])
    visited = [[False] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                heapq.heappush(queue, [0, i, j])
                break
    while queue:
        cost, x, y = heapq.heappop(queue)
        
        if board[x][y] == 'G':
            answer = cost
            break
        for d in range(4):
            curx = x
            cury = y
            while 0 <= curx+dxdy[d][0] < n and 0 <= cury+dxdy[d][1] < m and board[curx+dxdy[d][0]][cury+dxdy[d][1]] != 'D':
                curx += dxdy[d][0]
                cury += dxdy[d][1]
                
            if (curx != x or cury != y) and not visited[curx][cury]:
                visited[curx][cury] = True
                heapq.heappush(queue, [cost+1, curx, cury])
                
    return answer