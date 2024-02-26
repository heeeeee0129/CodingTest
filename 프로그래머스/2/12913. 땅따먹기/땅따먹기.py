def solution(land):
    answer = 0
    prev = -1
    for i in range(1, len(land)):
        for j in range(len(land[i])):
            land[i][j] += max(land[i-1][j+1:]+land[i-1][:j]) 
    return max(land[-1])


# 같은 점수가 주어진 경우, 각각의 경우를 고려해야 한다.
# def solution(land): 
#     answer = 0
#     prev = -1
#     for l in land:
#         max_el = -1
#         temp = -1
#         for idx, el in enumerate(l):
#             if prev == idx:
#                 continue
#             else:
#                 if max_el < el:
#                     max_el = el
#                     temp = idx
#         answer += max_el
#         prev = temp
    
#     return answer