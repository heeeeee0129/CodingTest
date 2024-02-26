from collections import deque

def check(queue, skill_tree):
    
    while(skill_tree and queue):
        cur = skill_tree.popleft()
        if queue[0] == cur:
            queue.popleft()
        elif cur in queue:
            
            return False
    
    return True
        


def solution(skill, skill_trees):
    answer = 0
    q = deque(skill)
    for tree in skill_trees:
        if check(deque(skill), deque(tree)):
            answer+=1
    return answer