def solution(nums):
    answer = 0
    dict = {}
    
    for num in nums:
        dict[num] = 1
        
    return min(len(dict), len(nums)//2)