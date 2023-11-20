from itertools import product

def solution(word):
    answer = 0
    dict = []
    alpha = "AEIOU"
#     none A E I O U * 5
# list(map(''.join,permutations(arr,2)))
    for i in range(1, 6):
        dict += list(map(''.join, product(alpha, repeat=i)))
    dict = sorted(set(dict))
    
    
    print(dict)
    for idx, i in enumerate(dict):
        if i == word:
            return idx+1
    
    return answer