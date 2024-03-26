def solution(storey):
    answer = 0
    nums = [0, 1, 2, 3, 4, 5, 4, 3, 2, 1]
    while storey:
        target = storey % 10
        storey = storey // 10
        if target <= 4:
            answer += nums[target]
        elif target > 5:
            answer += nums[target]
            storey += 1
        else:
            answer += 5
            if storey % 10 >= 5:
                storey += 1
    return answer