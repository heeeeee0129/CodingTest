import heapq

def solution(board):
    answer = 0
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    q = []
    heapq.heappush(q, [1, 0, 0, 0])
    costs = [[[int(1e9)]*len(board) for _ in range(len(board))] for _ in range(4)]
    
    while q:
        cost, x, y, direction = heapq.heappop(q)
        if x == y == len(board)-1:
            break
        
        for d in range(4):
            curx = x + dx[d]
            cury = y + dy[d]
            if 0 <= curx < len(board) and 0 <= cury < len(board) and board[curx][cury] == 0:
                if curx == len(board)-1 and cury == len(board)-1:
                    if d == direction:
                        c = cost
                    else:
                        c = cost+5
                    
                elif x + y == 0 or d == direction:
                    c = cost+1
                else:
                    c = cost+6
                
                if c <= costs[d][curx][cury]:
                    costs[d][curx][cury] = c
                    heapq.heappush(q, [c, curx, cury, d])
                    
    min_cost = min(costs[i][len(board) - 1][len(board)-1] for i in range(4))
    return min_cost*100