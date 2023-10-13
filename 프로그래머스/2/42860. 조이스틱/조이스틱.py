def solution(name):
    answer = 0
    min_move = len(name)-1
    
    for char in name:
        answer += min(ord(char)-ord('A'), 26-ord(char)+ord('A'))
    
    for i in range(len(name)):
        next = i+1
        while next < len(name) and name[next] == 'A':
            next+=1
        min_move = min(min_move, i+len(name)-next+min(i, len(name)-next))
        
    return min_move+answer
