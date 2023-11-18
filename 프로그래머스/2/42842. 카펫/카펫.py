def solution(brown, yellow):
    answer = []
    total = brown + yellow
    for i in range(1, total):
        if total % i == 0:
            if (i - 2) * ((total // i) - 2) == yellow:
                return [total//i, i] if i < total // i else [i, total//i]
        
    return answer