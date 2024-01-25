def solution(want, number, discount):
    answer = 0
    dict = {}
    for i in range(len(want)):
        dict[want[i]] = number[i]
    for i in range(10):
        if discount[i] in dict:
            dict[discount[i]] -= 1
    for i in range(10, len(discount)):
        if all(value <= 0 for value in dict.values()):
            answer+=1
        if discount[i-10] in dict:
            dict[discount[i-10]] += 1
        if discount[i] in dict:
            dict[discount[i]] -= 1
    if all(value <= 0 for value in dict.values()):
            answer+=1
    
    return answer
