def solution(X, Y):
    answer = ''
    count = [0] * 10
    for i in X:
        count[int(i)]+=1
    
    for i in Y:
        if count[int(i)] > 0:
            answer += i
            count[int(i)]-=1
    answer = ''.join(reversed(sorted(answer)))
    if not answer:
        return '-1'
    
    if answer[0] == '0':
        return '0'
    
    return answer