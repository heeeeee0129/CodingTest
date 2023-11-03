
def solution(progresses, speeds):
    answer = []
    done = 0
    while done < len(progresses):
        for i in range(done, len(progresses)):
            progresses[i] += speeds[i]
        
        if progresses[done] >= 100:
            count = 1
            for i in range(done+1, len(progresses)):
                if progresses[i] >= 100:
                    count+=1
                else:
                    break
            done += count
            answer.append(count)
        
    
    return answer