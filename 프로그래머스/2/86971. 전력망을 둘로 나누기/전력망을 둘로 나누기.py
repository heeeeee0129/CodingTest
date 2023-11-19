def dfs(graph, visited, node, wire):
    cnt = 1
    visited[node] = True
    for n in graph[node]:
        if not visited[n] and n not in wire:
            cnt += dfs(graph, visited, n, wire)
    return cnt


def solution(n, wires):
    answer = n
    graph = [[]for _ in range(n+1)]
    
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)
    
    for a, b in wires:
        # 현재 wire 하나를 끊고 bfs로 노드 개수 카운트
        visited = [False] * (n+1)
        cnt_a = dfs(graph, visited, a, [a,b])
        cnt_b = dfs(graph, visited, b, [a,b])
        answer = min(answer, abs(cnt_a-cnt_b))
        
    
    return answer