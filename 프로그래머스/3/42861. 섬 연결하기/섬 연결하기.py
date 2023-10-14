def solution(n, costs):
    answer = 0
    sorted_costs = sorted(costs, key=lambda x: x[2])
    islands = set([sorted_costs[0][0]]) # 하나의 섬부터 시작
    
    # cost의 값이 작은 경우들부터 확인
    
    while len(islands) < n:
        for idx,(i_1, i_2, cost) in enumerate(sorted_costs):
            
            # case 1: i_1, i_2 둘 다 이미 islands set에 포함되어 있는 경우 => pass-!
            # case 2: i_1 또는 i_2 중 하나만! islands set에 포함되어 있는 경우 -> 연결하면 됨
            # case 3: 둘 다 set에 포함되어 있지 않은 경우,,,? 이따 차차 연결해가며 다시 생각.
            if i_1 in islands and i_2 in islands:
                # del sorted_costs[idx]
                continue
            if i_1 in islands:
                answer+= cost
                islands.add(i_2)
                # del sorted_costs[idx]
                break
            if i_2 in islands:
                answer+=cost
                islands.add(i_1)
                # del sorted_costs[idx]
                break
    
    return answer