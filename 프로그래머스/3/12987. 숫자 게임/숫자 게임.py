def solution(A, B):
    answer = 0
    
    A.sort()
    B.sort()
    
    a_idx = 0
    b_idx = 0
    while b_idx < len(B):
        if A[a_idx] >= B[b_idx]:
            b_idx += 1
        else:
            answer += 1
            a_idx += 1
            b_idx += 1
    
    
    return answer
