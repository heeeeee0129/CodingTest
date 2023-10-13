def solution(number, k):
#     new_number = [] 

#     for i in number:
        
#         while new_number and new_number[-1] < i and k>0:
#             k-=1
#             new_number.pop()
            
#         new_number.append(i)
        
#     if k>0:
#         return ''.join(new_number[:-k])

#     return ''.join(new_number) 
    
    i = 0
    while i < len(number) - 1 and k > 0:
        if number[i]<number[i+1]:
            number = number[:i] + number[i+1:]
            i = max(0, i-1)
            k-=1
        else:
            i+=1
    if k > 0:
        return number[:-k]
    return number

