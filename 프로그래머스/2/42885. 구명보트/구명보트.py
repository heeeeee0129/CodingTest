def solution(people, limit):
    answer = 0
    people.sort(reverse=True)
    heavy = 0
    light = len(people)-1
    
    while heavy-light <= 0:
        if people[heavy]+people[light] <= limit:
            heavy +=1
            light -=1
            answer+=1
        else:
            heavy += 1
            answer+= 1
    
    return answer
