def solution(answers):
    answer = []
    one = [1,2,3,4,5]*2000
    two = [2,1,2,3,2,4,2,5]*1250
    three = [3,3,1,1,2,2,4,4,5,5]*1000
    count = [0]*3
    for idx, i in enumerate(answers):
        if i == one[idx]:
            count[0]+=1
        if i == two[idx]:
            count[1]+=1
        if i == three[idx]:
            count[2]+=1
    max_count = max(count)
    for idx, c in enumerate(count):
        if max_count == c:
            answer.append(idx+1)
    
    return answer