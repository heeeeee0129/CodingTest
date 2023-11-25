# 가장 짧은 변환 과정 -> BFS 선택
# 관건: 한 개의 알파벳만 바꿔 변환 가능한 단어 쌍 판별 
from collections import deque

def available(w1, w2):
    count = 0
    for c1, c2 in zip(w1, w2):
        if c1 != c2:
            count+=1
    return count == 1


def solution(begin, target, words):
    if target not in words:
        return 0
    
    # 인접 리스트 만들기. 변환 가능한 단어쌍 저장
    # 단어 배열 마지막에 begin도 추가
    # 단어는 인덱스로 접근
    
    words.append(begin)
    graph = [[] for _ in range(len(words)+1)]
    for i in range(len(words)):
        for j in range(len(words)):
            if available(words[i], words[j]):
                graph[i].append(j)
    print(graph)
                
    queue = deque([(len(words)-1, 0)]) # begin 단어, 횟수 카운트

    
    while deque:
        word, count = queue.popleft()
        if words[word] == target:
            return count
        for i in graph[word]:
            queue.append((i, count+1))
            
    return 0