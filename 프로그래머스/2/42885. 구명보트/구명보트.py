def solution(people, limit):
    answer = 0
    people.sort(reverse=True)
    heavy = 0
    light = len(people)-1
    
    # 포인트는 한 구명보트는 한 번에 최대 2명씩밖에 탈 수 없음
    # -> 두 개의 인덱스를 가리키는 변수 사용
    # 가장 무거운 애 먼저 태워보고, 가벼운 애 추가 가능하면 걔 넣고 태우기. 안 되면 무거운 애 한 명만
    
    
    while heavy <= light :
        if people[heavy]+people[light] <= limit:
            heavy +=1
            light -=1
            answer+=1
        else:
            heavy += 1
            answer+= 1
    
    return answer
