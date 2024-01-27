def solution(n, left, right):
    answer = []
    for i in range(left, right+1):
        answer.append(max(i//n, i%n)+1)
    return answer



# 첫 코드-!
# 일단 구현해서 돌려봤는데 역시는 역시, 시간초과.
# 2차원 배열 -> 1차원 배열 -> 슬라이싱
# 과정을 줄여야겠다 생각

# def solution(n, left, right):
#     arr = [[n for _ in range(n)] for _ in range(n)]
#     arr1 = []
    
#     for i in range(n-1, -1, -1):
#         for j in range(n-1, -1, -1):
#             arr[i][j] = max(i, j)+1
    
#     for row in arr:
#         arr1+=row
    
#     return arr1[left:right+1]