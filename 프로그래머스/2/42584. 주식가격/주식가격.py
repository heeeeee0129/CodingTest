def solution(prices):
    answer = []
    for i in range(len(prices)-1):
        now = prices[i]
        count = 1
        for j in range(i+1, len(prices)-1):
            if prices[j] < now:
                break
            else:
                count+=1
        answer.append(count)
    answer.append(0)
    return answer