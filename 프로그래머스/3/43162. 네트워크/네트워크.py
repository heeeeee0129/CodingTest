def dfs(visited, computer, computers):
    visited[computer] = 1
    for i in range(len(computers[computer])):
        if computers[computer][i] == 1 and not visited[i]:
            dfs(visited, i, computers)
    
    
def solution(n, computers):
    answer = 0
    visited = [0]*n
    
    for i in range(n):
        if not visited[i]:
            dfs(visited, i, computers)
            answer+=1
    
    
    return answer