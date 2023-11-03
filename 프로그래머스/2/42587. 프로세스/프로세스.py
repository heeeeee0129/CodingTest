def solution(priorities, location):
    answer = 1
    while len(priorities) > 1:
        max_priority = max(priorities)
        process = priorities.pop(0)
        if process == max_priority:
            if location == 0:
                return answer
            else:
                answer+=1
                location-=1
        else:
            priorities.append(process)
            if location==0:
                location = len(priorities)-1
            else:
                location -=1
    
    return answer

