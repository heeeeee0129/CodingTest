from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    graph = [[-1] * 102 for _ in range(102)]
    
    for start_x, start_y, end_x, end_y in rectangle:
        start_x *= 2
        start_y *= 2
        end_x *= 2
        end_y *= 2
        
        for i in range(start_x, end_x+1):
            for j in range(start_y, end_y+1):
                if (i == start_x or i == end_x or j == start_y or j == end_y) and graph[i][j] != 0 :
                    graph[i][j] = 1
                else:
                    graph[i][j] = 0
    
    queue = deque([(characterX*2, characterY*2, 1)])
    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    
    while queue:
        x, y, count = queue.popleft()
        graph[x][y] = -1
        
        for d in range(4):
            curx = x + dx[d]
            cury = y + dy[d]
            if curx == itemX*2 and cury == itemY*2:
                return count//2
            if graph[curx][cury] >=1:
                queue.append((curx, cury, count+1))
            