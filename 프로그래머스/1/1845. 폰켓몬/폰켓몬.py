def solution(nums):
    # dict = {}
    # for num in nums:
    #     dict[num] = 1  
    # return min(len(dict), len(nums)//2)
    nums_set = set(nums)
    return min(len(nums)//2, len(nums_set))