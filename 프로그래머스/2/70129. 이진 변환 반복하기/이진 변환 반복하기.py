def solution(s):
    count = 0
    zero_count = 0
    while s != "1":
        length = 0
        for i in s:
            if i == '1':
                length+=1
            else:
                zero_count+=1
        s = bin(length)[2:]
        count+=1
    
    return [count, zero_count]
