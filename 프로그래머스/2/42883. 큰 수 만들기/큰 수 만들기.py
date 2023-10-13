def solution(number, k):
    new_number = [] 

    for i in number:
        
        while new_number and new_number[-1] < i and k>0:
            k-=1
            new_number.pop()
            
        new_number.append(i)
        
    if k>0:
        return ''.join(new_number[:-k])

    return ''.join(new_number) 
