def solution(n):
    answer = 0
    for i in range(n):
        sum = 0
        for j in range(i,n):
            sum += j+1
            if sum == n:
                answer+=1
                break
            elif sum > n:
                break
                
    return answer