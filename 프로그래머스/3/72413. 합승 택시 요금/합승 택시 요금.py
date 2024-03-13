import heapq

def solution(n, s, a, b, fares):
    answer = 0
    arr = [[] for _ in range(n+1)]
    for fare in fares:
        c, d, f = fare
        arr[c].append((d, f))
        arr[d].append((c, f))
    
    q = []
    heapq.heappush(q, [0, [False]*(n+1), s, 2])
    while q:
        sum_cost, visited, node, count = heapq.heappop(q)
        print(node)
        visited[node] = True
        if node == a or node == b:
            count-=1
        if count == 0:
            answer=sum_cost
            break
        for connect in arr[node]:
            next_node, fare = connect
            if not visited[next_node]:
                heapq.heappush(q, [sum_cost+fare, visited, next_node, count])
    
    return answer


# 접근 방법
# 시간복잡도를 생각해야 하는 문제구나-! 정점/간선을 전체 탐색하면서 푸는 것은 안 되겠다. 최대한 효율적으로 !?
# 일단 시작점에서 출발-!해서 비용 카운트
# 
# heapq <- [sum_costs, visited, 현재 정점, A and B 카운트]

