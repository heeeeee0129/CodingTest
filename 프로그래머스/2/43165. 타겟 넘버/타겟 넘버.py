def dfs(numbers, sum, i, target):
    
    if i == len(numbers):
        return 1 if sum == target else 0
    
    number = numbers[i]
    count1 = dfs(numbers, sum+number, i+1, target)
    count2 = dfs(numbers, sum-number, i+1, target)
    
    return count1+count2

    
    

def solution(numbers, target):
    return dfs(numbers, 0, 0, target)