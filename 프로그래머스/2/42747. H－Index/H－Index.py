# def solution(citations):
#     answer = 0
#     citations.sort(reverse=True)    
#     for idx, i in enumerate(citations):
#         if idx > i:
#             return i
    
    
def solution(citations):
    answer = 0
    citations.sort(reverse=True)    
    for idx, citation in enumerate(citations, start=1):
        if idx <= citation:
            answer = idx
        else:
            break
    return answer
