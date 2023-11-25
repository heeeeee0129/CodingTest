from collections import defaultdict  

answer = []

def dfs(start, graph):
    while graph[start]:
        node = graph[start].pop()
        print(node)
        dfs(node, graph)
        
    if not graph[start]:
        answer.append(start)
        return
    
    
def solution(tickets):
    
    # 딕셔너리에 저장
    graph = defaultdict(list)
    for start, end in tickets:
        graph[start].append(end)
    # 항공권 정보 정렬
    for key in graph:
        graph[key].sort(reverse=True)
        
    dfs("ICN", graph)
    answer.reverse()
    
    return answer

